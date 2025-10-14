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

        String cantV = vta.Campo_CantidadVenta.getText().trim();
        int cantidadVender = Integer.parseInt(cantV);
        for (int i = 0; i < model.getRowCount(); i++) {
            try {

                String cod = model.getValueAt(i, 0).toString();
                int cod2 = Integer.parseInt(cod);

                String des = model.getValueAt(i, 1).toString();

                String talla = model.getValueAt(i, 2).toString();
                int talla2 = Integer.parseInt(talla);

                String ref = model.getValueAt(i, 3).toString();

                String precio = model.getValueAt(i, 4).toString();
                int precio2 = Integer.parseInt(precio);

                String cant = model.getValueAt(i, 5).toString();
                int cant2 = Integer.parseInt(cant);

                String valorT = model.getValueAt(i, 6).toString();
                int valorT2 = Integer.parseInt(valorT);

                String codigo = vta.Campo_CodigoVenta.getText();
                if (codigo.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "EL CAMPO DEL CODIGO NO PUEDE ESTAR VACIO");
                    return;
                }

                if (cantV.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "EL CAMPO CANTIDAD NO PUEDE ESTAR VACIO");
                    return;
                }

                if (cantidadVender <= 0) {
                    JOptionPane.showMessageDialog(null, "LA CANTIDAD A VENDER DEBE SER MAYOR A 0");
                    vta.Campo_CantidadVenta.requestFocus();
                    return;
                }

                //SE COMPARA EL STOCK DISPONIBLE
                PreparedStatement buscar = con.prepareStatement("SELECT* FROM INGRESOS WHERE CODIGO_I = ?");
                buscar.setString(1, codigo);
                ResultSet rs = buscar.executeQuery();
                if (rs.next()) {
                    this.cantDispo = rs.getInt("CANTIDAD");

                }
                if (cantidadVender > this.cantDispo) {
                    JOptionPane.showMessageDialog(null, "NO CUENTA CON LA CANTIDAD SUFICIENTE\nCANTIDAD DISPONIBLE: " + this.cantDispo);
                    vta.Campo_CantidadVenta.requestFocus();

                    return;// se detiene la ejecucion del método
                }

                PreparedStatement obt = con.prepareStatement("INSERT INTO FACTURA_PRODUCTOS(ID, FACTURA_ID, NOMBRE_PRODUCTO, REFERENCIA, TALLA, CANTIDAD, PRECIO_UNITARIO, TOTAL)"
                        + "VALUES (?,?,?,?,?,?,?,?");
                obt.setInt(1, cod2);
                obt.setInt(2, consecutivo);
                obt.setString(3, des);
                obt.setString(4, ref);
                obt.setInt(5, talla2);
                obt.setInt(6, cant2);
                obt.setInt(7, precio2);
                obt.setInt(8, valorT2);
                obt.executeUpdate();

                mvt.limpiar();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ERROR EN EL FORMATO DE NUMEROS: " + ex.getMessage());
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR SQL: " + e.getMessage());
            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgregar) {
            obtenerProducto();
        }
    }

}
