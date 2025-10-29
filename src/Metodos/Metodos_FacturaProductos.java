package Metodos;

import GUI.Ventas;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import gestor_ropa.BD_CONECCTION;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Metodos.Metodos_Ventas;
import java.math.BigDecimal;

public class Metodos_FacturaProductos implements ActionListener {

    BD_CONECCTION bd = new BD_CONECCTION();
    Connection con = bd.getconectar();
    Metodos_Ventas mvt;
    Ventas vta;
    private JButton btnAgregar;
    private int cantDispo;

    public Metodos_FacturaProductos(Ventas vta) {
        this.vta = vta;
        this.mvt = mvt;
        this.btnAgregar = this.vta.BTN_AgregarVenta;
    }

    private int generarConsecutivo() {
        DefaultTableModel model = (DefaultTableModel) vta.Tabla_Ventas.getModel();
        double total = 0.0;

        for (int i = 0; i < model.getRowCount(); i++) {
            try {
                String valorC = model.getValueAt(i, 6).toString();
                double subtotal = Double.parseDouble(valorC);

                total += subtotal;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ERROR AL PARSEAR LA FILA " + i + ": " + e.getMessage());
            }
        }

        try {
            // Primero obtener el próximo consecutivo
            String obtenerConsecutivoSQL = "SELECT COALESCE(MAX(CAST(SUBSTRING(CONSECUTIVO, 5) AS UNSIGNED)), 0) + 1 FROM FACTURAS WHERE CONSECUTIVO LIKE 'FAC.%'";

            int nextConsecutive = 1;
            try (PreparedStatement stmt = con.prepareStatement(obtenerConsecutivoSQL); ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    nextConsecutive = rs.getInt(1);
                }
            }

            // Formatear el consecutivo: "FAC.0001"
            String consecutivoFormateado = "FAC." + String.format("%04d", nextConsecutive);

            // Insertar la nueva factura
            String insertSQL = "INSERT INTO FACTURAS (CONSECUTIVO, TOTAL, FECHA_CREACION) VALUES (?,?, NOW())";
            PreparedStatement consecutive = con.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

            consecutive.setString(1, consecutivoFormateado);
            consecutive.setDouble(2, total);
            consecutive.executeUpdate();

            // Obtener el ID generado
            ResultSet rs = consecutive.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: " + e);
        }
        return -1;
    }

    public void buscar() {
        try {
            PreparedStatement buscar = con.prepareStatement("SELECT * FROM INGRESOS WHERE CODIGO_I = ?");
            buscar.setString(1, vta.Campo_CodigoVenta.getText());
            ResultSet rs = buscar.executeQuery();
            if (rs.next()) {
                vta.Campo_DescripcionVenta.setText(rs.getString("DESCRIPCION"));
                vta.Campo_ReferenciaVenta.setText(rs.getString("REFERENCIA"));
                vta.Campo_TallaVenta.setText(rs.getString("TALLA"));
                vta.Campo_COSTOventa.setText(rs.getString("COSTO"));
                vta.Campo_PrecioVenta1.setText(rs.getString("PRECIO"));

                this.cantDispo = rs.getInt("CANTIDAD");
            } else {
                JOptionPane.showMessageDialog(null, "NO SE ENCONTRO NINGUN REGISTRO CON ESE CODIGO");
                this.cantDispo = 0;

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: " + e.getMessage());

        }
    }

//    public void obtenerTotal() {
//        try {
//            DefaultTableModel model = (DefaultTableModel) vta.Tabla_Ventas.getModel();// SE OBTIENE EL MODELO DE DATOS DE LA TABLA
//
//            double totalGeneral = 0.0;// se inicializa una variable para guardar la suma total
//
//            for (int i = 0; i < model.getRowCount(); i++) {//se recorre todas las filas de la tabla
//                try {
//                    String valorcelda = model.getValueAt(i, 6).toString();//se obtiene el valor de la columna "VALOR TOTAL", INDICE 6
//                    double subtotal = Double.parseDouble(valorcelda);//se convierte de objeto a String y luego a double para poder sumarlo
//
//                    totalGeneral += subtotal;
//                } catch (NumberFormatException e) {
//                    JOptionPane.showMessageDialog(null, "Error al parsear el valor en la fila " + i + ":" + e.getMessage());
//                }
//            }
//
//            PreparedStatement cs = con.prepareStatement("UPDATE FACTURA_PRODUCOS SET TOTAL = ? WHERE ID = ?");
//            cs.setDouble(1, totalGeneral);
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "[ERROR]: " + e.getMessage());
//        }
//    }

    public void obtenerProducto() {
        int consecutivo = generarConsecutivo();
        String total = vta.Campo_TotalVenta.getText();

        try {

            DefaultTableModel model = (DefaultTableModel) vta.Tabla_Ventas.getModel();// SE OBTIENE EL MODELO DE DATOS DE LA TABLA

            double totalGeneral = 0.0;// se inicializa una variable para guardar la suma total

            for (int i = 0; i < model.getRowCount(); i++) {//se recorre todas las filas de la tabla
                try {
                    String valorcelda = model.getValueAt(i, 6).toString();//se obtiene el valor de la columna "VALOR TOTAL", INDICE 6
                    double subtotal = Double.parseDouble(valorcelda);//se convierte de objeto a String y luego a double para poder sumarlo

                    totalGeneral += subtotal;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error al parsear el valor en la fila " + i + ":" + e.getMessage());
                }
            }
            PreparedStatement obt = con.prepareStatement("INSERT INTO FACTURA_PRODUCTOS(FACTURA_ID, NOMBRE_PRODUCTO, TALLA, REFERENCIA, PRECIO_UNITARIO, CANTIDAD, TOTAL) VALUES (?,?,?,?,?,?,?)");
            obt.setInt(1, consecutivo);
            obt.setString(2, vta.Campo_DescripcionVenta.getText());
            obt.setString(3, vta.Campo_TallaVenta.getText());
            obt.setString(4, vta.Campo_ReferenciaVenta.getText());
            obt.setString(5, vta.Campo_PrecioVenta1.getText());
            obt.setString(6, vta.Campo_CantidadVenta.getText());
            obt.setDouble(7, totalGeneral);

            obt.executeUpdate();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ERROR EN EL FORMATO DE NUMEROS: " + ex.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR SQL: " + e.getMessage());
        }
    }

    public void facturas() {
        int consecutivo2 = generarConsecutivo();

        try {
            PreparedStatement fac = con.prepareStatement("INSERT INTO FACURAS(CONSECUTIVO) VALUES (?)");
            fac.setInt(1, consecutivo2);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: " + e.getMessage());
        }
    }

    public void cancelar() {
        try {
            PreparedStatement cn = con.prepareStatement("TRUNCATE TABLE FACTURA_PRODUCTOS");
            cn.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgregar) {
            obtenerProducto();
        }
        if (e.getSource() == btnAgregar) {
            facturas();
        }
    }

}
