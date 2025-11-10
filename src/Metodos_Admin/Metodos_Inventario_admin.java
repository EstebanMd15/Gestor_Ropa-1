package Metodos_Admin;

import Metodos.*;
import GUI.Inventario;
import GUI.INGRESO;
import GUI_ADMIN.Inventario_ADMIN;
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

public class Metodos_Inventario_admin implements ActionListener {

    Connection con = BD_CONECCTION.getInstance().getconectar();

    private Inventario_ADMIN inventarioIu;
    private JButton btnBuscar;
    private JButton btnLimpiar;
    INGRESO ig = new INGRESO();

    public Metodos_Inventario_admin(Inventario_ADMIN inventarioIu) {
        this.inventarioIu = inventarioIu;
        this.btnBuscar = this.inventarioIu.BTN_BuscarCodInven_admin;
        this.btnLimpiar = this.inventarioIu.BTN_LimpiarInven_admin;
        
    }


    public void buscarCodigo() {

        try {
            PreparedStatement buscar = BD_CONECCTION.getInstance().getconectar().prepareStatement("SELECT * FROM INGRESOS WHERE CODIGO_I = ?");
            buscar.setString(1, inventarioIu.Campo_CodigoInventario_admin.getText());
            ResultSet rs = buscar.executeQuery();
            if (rs.next()) {
                inventarioIu.Campo_CostoInventario_admin.setText(rs.getString("COSTO"));
                inventarioIu.Campo_DescripcionInventario_admin.setText(rs.getString("DESCRIPCION"));
                inventarioIu.Campo_FechaIngresoInven_admin.setText(rs.getString("FECHA_INGRESO"));
                inventarioIu.Campo_ReferenciaInventario_admin.setText(rs.getString("REFERENCIA"));
                inventarioIu.Campo_TallaInventario_admin.setText(rs.getString("TALLA"));
                inventarioIu.Campo_PrecioInventario_admin.setText(rs.getString("PRECIO"));

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
            PreparedStatement cant = BD_CONECCTION.getInstance().getconectar().prepareStatement("SELECT * FROM INGRESOS WHERE CODIGO_I = ?");
            cant.setString(1, inventarioIu.Campo_CodigoInventario_admin.getText());
            ResultSet rs = cant.executeQuery();
            if (rs.next()) {
                inventarioIu.Campo_CantidadDispoInven_admin.setText(rs.getString("CANTIDAD"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: " + e.getMessage());
        }
    }

    public void limpiarCampos() {

        inventarioIu.Campo_CantidadDispoInven_admin.setText("");
        inventarioIu.Campo_CodigoInventario_admin.setText("");
        inventarioIu.Campo_CostoInventario_admin.setText("");
        inventarioIu.Campo_DescripcionInventario_admin.setText("");
        inventarioIu.Campo_FechaIngresoInven_admin.setText("");
        inventarioIu.Campo_PrecioInventario_admin.setText("");
        inventarioIu.Campo_ReferenciaInventario_admin.setText("");
        inventarioIu.Campo_TallaInventario_admin.setText("");
    }


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
