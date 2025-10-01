package Metodos;

import GUI.Inventario;
import GUI.INGRESO;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import gestor_ropa.BD_CONECCTION;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Metodos_Inventario implements ActionListener {

    BD_CONECCTION bd1 = new BD_CONECCTION();
    Connection con = bd1.conectar();

    private Inventario inventarioIu;
    private JButton btnBuscar;
    private JButton btnLimpiar;
    INGRESO ig = new INGRESO();

    public Metodos_Inventario(Inventario inventarioIu) {
        this.inventarioIu = inventarioIu;
        this.btnBuscar = this.inventarioIu.BTN_BuscarCodInven;
        this.btnLimpiar = this.inventarioIu.BTN_LimpiarInven;
        
    }


    public void buscarCodigo() {

        try {
            PreparedStatement buscar = con.prepareStatement("SELECT * FROM Ingresos WHERE CODIGO = ?");
            buscar.setString(1, inventarioIu.Campo_CodigoInventario.getText());
            ResultSet rs = buscar.executeQuery();
            if (rs.next()) {
                inventarioIu.Campo_CostoInventario.setText(rs.getString("COSTO"));
                inventarioIu.Campo_DescripcionInventario.setText(rs.getString("DESCRIPCION"));
                inventarioIu.Campo_FechaIngresoInven.setText(rs.getString("FECHA_INGRESO"));
                inventarioIu.Campo_ReferenciaInventario.setText(rs.getString("REFERENCIA"));
                inventarioIu.Campo_TallaInventario.setText(rs.getString("TALLA"));
                inventarioIu.Campo_PrecioInventario.setText(rs.getString("PRECIO"));

                // Campo_CantidadDispoInven.setText(String.valueOf(disponible));//PERMITE CAMBIAR TIPO DE DATOS A CADENA DE TEXTO
            } else {
                JOptionPane.showMessageDialog(null, "NO SE ENCONTRO NINGUN REGISTRO CON ESE CODIGO");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: " + e.getMessage());
        }

    }

    public void cantidadDisponible() {
        try {
            PreparedStatement cant = con.prepareStatement("SELECT * FROM Ingresos WHERE CODIGO = ?");
            cant.setString(1, inventarioIu.Campo_CodigoInventario.getText());
            ResultSet rs = cant.executeQuery();
            if (rs.next()) {
                inventarioIu.Campo_CantidadDispoInven.setText(rs.getString("CANTIDAD"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: " + e.getMessage());
        }
    }

    public void limpiarCampos() {

        inventarioIu.Campo_CantidadDispoInven.setText("");
        inventarioIu.Campo_CodigoInventario.setText("");
        inventarioIu.Campo_CostoInventario.setText("");
        inventarioIu.Campo_DescripcionInventario.setText("");
        inventarioIu.Campo_FechaIngresoInven.setText("");
        inventarioIu.Campo_PrecioInventario.setText("");
        inventarioIu.Campo_ReferenciaInventario.setText("");
        inventarioIu.Campo_TallaInventario.setText("");
    }

//    public void calculo() {
//
//        try {
//            double costoBase = 0;
//
//            PreparedStatement cal = con.prepareStatement("SELECT * FROM Ingresos WHERE CODIGO = ?");
//            cal.setString(1, ig.Campo_Codigo.getText());
//            ResultSet rs = cal.executeQuery();
//            if (rs.next()) {
//                String costoBD = rs.getString("COSTO");
//                if (costoBD != null && !costoBD.isEmpty()) {
//                    costoBase = Double.parseDouble(costoBD);
//                    ig.Campo_Costo.setText(costoBD);
//                }
//            } else {
//                String costoInv = inventarioIu.Campo_CostoInventario.getText();
//                if (costoInv != null && !costoInv.isEmpty()) {
//                    costoBase = Double.parseDouble(costoInv);
//                }
//            }
//            double preciofinal;
//
//            if (costoBase > 5000) {
//                preciofinal = costoBase * 1.30;
//            } else {
//                preciofinal = costoBase;
//            }
//            inventarioIu.Campo_PrecioInventario.setText(String.valueOf(preciofinal));
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "[ERROR]: " + e.getMessage());
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(null, "[ERROR EN EL FORMATO]: VERIFIQUE QUE LOS CAMPOS TENGAN VALORES VALIDOS" + e.getMessage());
//        } catch (Exception e){
//            JOptionPane.showMessageDialog(null, "[ERROR]: " + e.getMessage());
//        }
//
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBuscar) {
            buscarCodigo();
            if (e.getSource() == btnLimpiar) {
                limpiarCampos();
            }

        }
    }

}
