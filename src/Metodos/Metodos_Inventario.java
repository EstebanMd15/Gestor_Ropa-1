package Metodos;

import GUI.Inventario;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import gestor_ropa.BD_CONECCTION;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Metodos_Inventario implements ActionListener {

    BD_CONECCTION bd1 = new BD_CONECCTION();
    Connection con = bd1.conectar();

    public void buscarCodigo() {

        Inventario in = new Inventario();

        try {
            PreparedStatement buscar = con.prepareStatement("SELECT * FROM Ingresos WHERE CODIGO = ?");
            buscar.setString(1, in.Campo_CodigoInventario.getText());
            ResultSet rs = buscar.executeQuery();
            if (rs.next()) {
                in.Campo_CostoInventario.setText(rs.getString("COSTO"));
                in.Campo_DescripcionInventario.setText(rs.getString("DESCRIPCION"));
                in.Campo_FechaIngresoInven.setText(rs.getString("FECHA_INGRESO"));
                in.Campo_ReferenciaInventario.setText(rs.getString("REFERENCIA"));
                in.Campo_TallaInventario.setText(rs.getString("TALLA"));

                // Campo_CantidadDispoInven.setText(String.valueOf(disponible));//PERMITE CAMBIAR TIPO DE DATOS A CADENA DE TEXTO
            } else {
                JOptionPane.showMessageDialog(null, "NO SE ENCONTRO NINGUN REGISTRO CON ESE CODIGO");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: " + e.getMessage());
        }

//        try {
//            PreparedStatement buscar = con1.prepareStatement("SELECT * FROM Ingresos WHERE CODIGO = ?");
//            buscar.setString(1, in.Campo_CodigoInventario.getText());
//            ResultSet rs = buscar.executeQuery();
//            if(rs.next()){
//                in.Campo_CostoInventario.setText(rs.getString("COSTO"));
//                in.Campo_DescripcionInventario.setText(rs.getString("DESCRIPCION"));
//                in.Campo_FechaIngresoInven.setText(rs.getString("FECHA_INGRESO"));
//                in.Campo_ReferenciaInventario.setText(rs.getString("REFERENCIA"));
//                in.Campo_TallaInventario.setText(rs.getString("TALLA"));
//            }else{
//                JOptionPane.showMessageDialog(null, "NO SE ENCONTRÓ NINGUN REGISTRO CON ESE CÓDIGO");
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "[ERROR]: " + e.getMessage());
//        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
