package Metodos_Admin;

import Metodos.*;
import gestor_ropa.BD_CONECCTION;
import java.sql.*;
import java.sql.PreparedStatement;
import GUI.INGRESO;
import GUI.Ventas;
import GUI_ADMIN.INGRESO_ADMIN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author esteb
 */
public class Metodos_Ingresos_admin  implements ActionListener {
    BD_CONECCTION bd;
    Connection con = BD_CONECCTION.getInstance().getconectar();
    private INGRESO_ADMIN iga;
    private Ventas vt;
    private JButton btnGuardar;
    private JButton btnBuscar;
    private JButton btnModificar;
    private JButton btnLimpiar;

    public Metodos_Ingresos_admin(INGRESO_ADMIN ig) {
        this.bd = BD_CONECCTION.getInstance();
        this.iga = ig;
        this.vt = vt;
        this.btnGuardar = this.iga.BTN_Guardar_admin;
        this.btnBuscar = this.iga.BTN_Buscar_admin;
        this.btnModificar = this.iga.BTN_Modificar_admin;
        this.btnLimpiar = this.iga.BTN_Limpiar_admin;
    }

    public boolean eliminarRegistros(String[] TablasOrden) {
        Statement stm = null;

        try {
            bd.getconectar().setAutoCommit(false);
            stm = bd.getconectar().createStatement();

            stm.execute("SET FOREIGN_KEY_CHECKS = 0");

            for (String tabla : TablasOrden) {
                String sql = "TRUNCATE TABLE " + tabla;
                stm.executeUpdate(sql);
                System.out.println("TABLA TRUNCADA: " + tabla);
            }

            stm.execute("SET FOREIGN_KEY_CHECKS = 1");
            bd.getconectar().commit();

            int confirmacion = JOptionPane.showConfirmDialog(null, "DESEA ELIMINAR TODOS LOS REGISTROS");
            if (confirmacion == 0) {
                JOptionPane.showMessageDialog(null, "REGISTROS ELIMINADOS CON EXITO");
            }
            iga.mostrar("INGRESOS");
                return true;
            }catch (SQLException e) {
            try {
                if(bd.getconectar() != null){
                    if(stm != null){
                        stm.execute("SET FOREIGN_KEY_CHECKS = 1");
                    }
                    bd.getconectar().rollback();
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "[ERROR]: " + ex);
}                  
JOptionPane.showMessageDialog(null,"[ERROR]: " + e);
                return false;
            }finally{
                try {
                  if(stm != null) stm.close();
                  if(bd.getconectar() != null){
                      bd.getconectar().setAutoCommit(true);
                      bd.getconectar().close();
                  }
                } catch (SQLException em) {
                    JOptionPane.showMessageDialog(null,"[ERROR]: " + em);
                }
            }
        }
    

    

    public void guardar() {
        int cantIngreso = Integer.parseInt(iga.Campo_Cantidad_admin.getText());
        java.sql.Date fechaActual = new java.sql.Date(System.currentTimeMillis());
        try {
            PreparedStatement guardar = BD_CONECCTION.getInstance().getconectar().prepareStatement("INSERT INTO INGRESOS (CODIGO_I, DESCRIPCION, REFERENCIA, TALLA, CANTIDAD, COSTO, FECHA_INGRESO, OBSERVACION, PRECIO) VALUES (?,?,?,?,?,?,?,?,?)");
            guardar.setString(1, iga.Campo_Codigo_admin.getText());
            guardar.setString(2, iga.Campo_Descripcion_admin.getText());
            guardar.setString(3, iga.Campo_Referencia_admin.getText());
            guardar.setString(4, iga.Campo_Talla_admin.getText());
            guardar.setInt(5, cantIngreso);
            guardar.setString(6, iga.Campo_Costo_admin.getText());
            guardar.setString(7, fechaActual.toString());
            guardar.setString(8, iga.Campo_Observacion_admin.getText());
            guardar.setString(9, iga.Campo_PrecioVenta_admin.getText());

            iga.Campo_Cantidad_admin.setText("");
            iga.Campo_Codigo_admin.setText("");
            iga.Campo_Costo_admin.setText("");
            iga.Campo_Descripcion_admin.setText("");
            iga.Campo_Observacion_admin.setText("");
            iga.Campo_Referencia_admin.setText("");
            iga.Campo_Talla_admin.setText("");
            iga.Campo_PrecioVenta_admin.setText("");
            guardar.executeUpdate();// ejecuta sentencias sql que modifiquen datos como INSERT, DELETE, UPDATE
            JOptionPane.showMessageDialog(null, "REGISTRADO");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: " + e.getMessage());
        }
    }

    public void buscar() {
        try {
            PreparedStatement guardar = BD_CONECCTION.getInstance().getconectar().prepareStatement("SELECT * FROM INGRESOS WHERE CODIGO_I = ?");
            guardar.setString(1, iga.Campo_Codigo_admin.getText());
            ResultSet rs = guardar.executeQuery();
            if (rs.next()) {
                iga.Campo_Cantidad_admin.setText(rs.getString("CANTIDAD"));
                iga.Campo_Codigo_admin.setText(rs.getString("CODIGO_I"));
                iga.Campo_Costo_admin.setText(rs.getString("COSTO"));
                iga.Campo_Descripcion_admin.setText(rs.getString("DESCRIPCION"));
                iga.Campo_Observacion_admin.setText(rs.getString("OBSERVACION"));
                iga.Campo_Referencia_admin.setText(rs.getString("REFERENCIA"));
                iga.Campo_Talla_admin.setText(rs.getString("TALLA"));
                iga.Campo_PrecioVenta_admin.setText(rs.getString("PRECIO"));
            } else {
                JOptionPane.showMessageDialog(null, "NO SE ENCONTRO NINGUN REGISTRO CON ESE CODIGO");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: " + e.getMessage());
        }
    }

    public void modificar() {
        String precio = iga.Campo_PrecioVenta_admin.getText();
        BigDecimal precioF = new BigDecimal(precio);
        try {
            PreparedStatement modificar = BD_CONECCTION.getInstance().getconectar().prepareStatement("UPDATE INGRESOS SET DESCRIPCION =?, REFERENCIA =?, TALLA =?, CANTIDAD =?, COSTO =?, OBSERVACION =?, PRECIO =? WHERE CODIGO_I = ?");
            modificar.setString(1, iga.Campo_Descripcion_admin.getText());
            modificar.setString(2, iga.Campo_Referencia_admin.getText());
            modificar.setString(3, iga.Campo_Talla_admin.getText());
            modificar.setString(4, iga.Campo_Cantidad_admin.getText());
            modificar.setString(5, iga.Campo_Costo_admin.getText());
            modificar.setString(6, iga.Campo_Observacion_admin.getText());
            modificar.setBigDecimal(7, precioF);
            modificar.setString(8, iga.Campo_Codigo_admin.getText());
            int modificar2 = JOptionPane.showConfirmDialog(null, "DESEA MODIFICAR EL INGRESO ?");
            if (modificar2 == 0) {
                int filas = modificar.executeUpdate();
                if (filas != 0) {
                    modificar.executeUpdate();
                    iga.Campo_Cantidad_admin.setText("");
                    iga.Campo_Codigo_admin.setText("");
                    iga.Campo_Costo_admin.setText("");
                    iga.Campo_Descripcion_admin.setText("");
                    iga.Campo_Observacion_admin.setText("");
                    iga.Campo_Referencia_admin.setText("");
                    iga.Campo_Talla_admin.setText("");
                    iga.Campo_PrecioVenta_admin.setText("");
                }
                JOptionPane.showMessageDialog(null, "REGISTRO ACTUALIZADO CON EXITO");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: " + e.getMessage());

        }
    }

    public void limpiar() {
        iga.Campo_Cantidad_admin.setText("");
        iga.Campo_Codigo_admin.setText("");
        iga.Campo_Costo_admin.setText("");
        iga.Campo_Descripcion_admin.setText("");
        iga.Campo_Observacion_admin.setText("");
        iga.Campo_Referencia_admin.setText("");
        iga.Campo_Talla_admin.setText("");
        iga.Campo_PrecioVenta_admin.setText("");
    }

    public void calcularPrecioVenta() {
        DefaultTableModel model = (DefaultTableModel) iga.Tabla_Ingresos.getModel();
        double totalVenta = 0.0;

        for (int i = 0; i < model.getRowCount(); i++) {
            try {
                String valorcelda = model.getValueAt(i, 9).toString();
                double total = Double.parseDouble(valorcelda);

                totalVenta += total;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ERROR AL PARSEAR LA FILA " + i + ":" + e.getMessage());
            }
        }
        vt.Campo_TotalVenta.setText(String.format("%.2f", totalVenta));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGuardar) {
            guardar();
        }
        if (e.getSource() == btnBuscar) {
            buscar();
        }
        if (e.getSource() == btnModificar) {
            modificar();
        }
        if (e.getSource() == btnLimpiar) {
            limpiar();

        }

    }

}
