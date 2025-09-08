package Metodos;

import gestor_ropa.BD_CONECCTION;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import GUI.INGRESO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Metodos_Ingresos implements ActionListener {

    BD_CONECCTION bd = new BD_CONECCTION();
    Connection cn = bd.conectar();
    private INGRESO ig;
    private JButton btnGuardar;
    private JButton btnBuscar;
    private JButton btnModificar;
    private JButton btnLimpiar;

    public Metodos_Ingresos(INGRESO ig) {
        this.ig = ig;
        this.btnGuardar = this.ig.BTN_Guardar;
        this.btnBuscar = this.ig.BTN_Buscar;
        this.btnModificar = this.ig.BTN_Modificar;
        this.btnLimpiar = this.ig.BTN_Limpiar;
    }
    
    public void eliminarRegistros(){
        try {
            PreparedStatement eliminarReg = cn.prepareStatement("TRUNCATE TABLE Ingresos");
            eliminarReg.executeUpdate();
            JOptionPane.showMessageDialog(null, "INGRESOS ELIMINADOS EXITOSAMENTE");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"[ERROR]: " +  e.getMessage());
        }
    }

    public void guardar(){
        int cantIngreso = Integer.parseInt(ig.Campo_Cantidad.getText());
        java.sql.Date fechaActual = new java.sql.Date(System.currentTimeMillis());
        try {
            PreparedStatement guardar = cn.prepareStatement("INSERT INTO Ingresos (CODIGO, DESCRIPCION, REFERENCIA, TALLA, CANTIDAD, COSTO, FECHA_INGRESO, OBSERVACION) VALUES (?,?,?,?,?,?,?,?)");
            guardar.setString(1, ig.Campo_Codigo.getText());
            guardar.setString(2, ig.Campo_Descripcion.getText());
            guardar.setString(3, ig.Campo_Referencia.getText());
            guardar.setString(4, ig.Campo_Talla.getText());
            guardar.setInt(5, cantIngreso);
            guardar.setString(6, ig.Campo_Costo.getText());
            guardar.setString(7, fechaActual.toString());
            guardar.setString(8, ig.Campo_Observacion.getText());
            
            ig.Campo_Cantidad.setText("");
            ig.Campo_Codigo.setText("");
            ig.Campo_Costo.setText("");
            ig.Campo_Descripcion.setText("");
            ig.Campo_Observacion.setText("");
            ig.Campo_Referencia.setText("");
            ig.Campo_Talla.setText("");
            guardar.executeUpdate();// ejecuta sentencias sql que modifiquen datos como INSERT, DELETE, UPDATE
            JOptionPane.showMessageDialog(null, "REGISTRADO");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"[ERROR]: " + e.getMessage());
        }
    }
    
    public void buscar(){
        try {
            PreparedStatement guardar = cn.prepareStatement("SELECT * FROM Ingresos WHERE CODIGO = ?");
            guardar.setString(1, ig.Campo_Codigo.getText());
            ResultSet rs = guardar.executeQuery();
            if(rs.next()){
                ig.Campo_Cantidad.setText(rs.getString("CANTIDAD"));
                ig.Campo_Codigo.setText(rs.getString("CODIGO"));
                ig.Campo_Costo.setText(rs.getString("COSTO"));
                ig.Campo_Descripcion.setText(rs.getString("DESCRIPCION"));
                ig.Campo_Observacion.setText(rs.getString("OBSERVACION"));
                ig.Campo_Referencia.setText(rs.getString("REFERENCIA"));
                ig.Campo_Talla.setText(rs.getString("TALLA"));
            }else{
                JOptionPane.showMessageDialog(null, "NO SE ENCONTRO NINGUN REGISTRO CON ESE CODIGO");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: " + e.getMessage());
        }
    }
    
    public void modificar(){
        try {
            PreparedStatement modificar = cn.prepareStatement("UPDATE Ingresos SET DESCRIPCION =?, REFERENCIA =?, TALLA =?, CANTIDAD =?, COSTO =?, OBSERVACION =? WHERE CODIGO = ?");
            modificar.setString(1, ig.Campo_Descripcion.getText());
            modificar.setString(2, ig.Campo_Referencia.getText());
            modificar.setString(3, ig.Campo_Talla.getText());
            modificar.setString(4, ig.Campo_Cantidad.getText());
            modificar.setString(5, ig.Campo_Costo.getText());
            modificar.setString(6, ig.Campo_Observacion.getText());
            modificar.setString(7, ig.Campo_Codigo.getText());
            int modificar2 = JOptionPane.showConfirmDialog(null, "DESEA MODIFICAR EL INGRESO ?");
            if(modificar2 == 0){
                int filas = modificar.executeUpdate();
            if(filas != 0){
                modificar.executeUpdate();
            ig.Campo_Cantidad.setText("");
            ig.Campo_Codigo.setText("");
            ig.Campo_Costo.setText("");
            ig.Campo_Descripcion.setText("");
            ig.Campo_Observacion.setText("");
            ig.Campo_Referencia.setText("");
            ig.Campo_Talla.setText("");
            }
                JOptionPane.showMessageDialog(null, "REGISTRO ACTUALIZADO CON EXITO");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"[ERROR]: "+ e.getMessage());
                    
        }
    }
    
    public void limpiar(){
        ig.Campo_Cantidad.setText("");
        ig.Campo_Codigo.setText("");
        ig.Campo_Costo.setText("");
        ig.Campo_Descripcion.setText("");
        ig.Campo_Observacion.setText("");
        ig.Campo_Referencia.setText("");
        ig.Campo_Talla.setText("");
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnGuardar){
            guardar(); 
        }
        if(e.getSource() == btnBuscar){
            buscar();   
        }
        if(e.getSource() == btnModificar){
            modificar();
        }
        if(e.getSource() == btnLimpiar){
            limpiar();
            
        }
        
    }

}
