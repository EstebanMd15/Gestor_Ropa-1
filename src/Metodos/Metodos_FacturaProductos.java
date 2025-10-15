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
    Connection con = bd.conectar();
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

    public void obtenerProducto() {
        DefaultTableModel model = (DefaultTableModel) vta.Tabla_Ventas.getModel();
        int consecutivo = generarConsecutivo();
        for (int i = 0; i < model.getRowCount(); i++) {     
            try {

                String des = model.getValueAt(i, 1).toString();

                String talla = model.getValueAt(i, 2).toString();

                String ref = model.getValueAt(i, 3).toString();

                double precio = Double.parseDouble(model.getValueAt(i, 4).toString());
                BigDecimal precio2 = new BigDecimal(precio);

                String cant = model.getValueAt(i, 5).toString();
                int cant2 = Integer.parseInt(cant);

                double valorT = Double.parseDouble(model.getValueAt(i, 6).toString());
                BigDecimal valorT2 = new BigDecimal(valorT);


                PreparedStatement obt = con.prepareStatement("INSERT INTO FACTURA_PRODUCTOS(ID_FACTURA, NOMBRE_PRODUCTO, TALLA, REFERENCIA, PRECIO_UNITARIO, CANTIDAD, TOTAL) VALUES (?,?,?,?,?,?)");
                obt.setInt(1, consecutivo);
                obt.setString(2, des);
                obt.setString(3, talla);
                obt.setString(4, ref);
                obt.setBigDecimal(5, precio2);
                obt.setInt(6, cant2);
                obt.setBigDecimal(7, valorT2);
                obt.executeUpdate();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ERROR EN EL FORMATO DE NUMEROS: " + ex.getMessage());
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR SQL: " + e.getMessage());
            }

        }

    }
    
    public void facturas(){
        int consecutivo2 = generarConsecutivo();
              
        try {
            PreparedStatement fac = con.prepareStatement("INSERT INTO FACURAS(CONSECUTIVO) VALUES (?)");
            fac.setInt(1, consecutivo2 );
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: " + e.getMessage());
        }
    }
    
    public void cancelar(){
        try {
            PreparedStatement cn = con.prepareStatement("TRUNCATE TABLE FACTURA_PRODUCTOS");
            cn.executeUpdate();
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"[ERROR]: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgregar) {
            obtenerProducto();
        }
        if(e.getSource() == btnAgregar){
            facturas();
        }
    }

}
