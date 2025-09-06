package Metodos;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import gestor_ropa.BD_CONECCTION;
import GUI.INGRESO;
import GUI.Lista_Precios;
import GUI.Ventas;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Metodos_ListaPrecios extends Ventas implements ActionListener {
    
    Ventas puntoVenta = new Ventas();
    
    BD_CONECCTION bd = new BD_CONECCTION();
    Connection con = bd.conectar();
    Ventas vt = new Ventas();

    private JButton BtnAgregar;
    private JButton BtnBuscar;
    private JButton BtnEliminar;
    private JButton BtnModificar;
    private JButton BtnMostrar;
    private JButton BtnSalir;
    private Lista_Precios lp;

    public Metodos_ListaPrecios(Lista_Precios lp) {
        this.lp = lp;
        this.BtnAgregar = this.lp.Btn_AgregarLP;
        this.BtnBuscar = this.lp.Btn_BuscarLP;
        this.BtnEliminar = this.lp.Btn_EliminarLP;
        this.BtnModificar = this.lp.Btn_ModificarLP;
        this.BtnMostrar = this.lp.Btn_MostrarLP;
        this.BtnSalir = this.lp.Btn_SalirLP;
    }
    
    public Metodos_ListaPrecios(Ventas puntoVenta){
        this.puntoVenta = puntoVenta;
    }

        public void actualizaListas(){
        if(vt.ComboBox_ListasP == null) return;
            
        //Obtenemos el modelo del comboBox para manipularlo
        DefaultComboBoxModel<String> modelo = (DefaultComboBoxModel<String>) vt.ComboBox_ListasP.getModel();
        //Se limpia los items para no duplicar datos
        modelo.removeAllElements();
        //Se crea una lista para guardar los nombres de las listas de la BD
        List<String> listaPrecios = new ArrayList<>();
        //SE EJECUTA LA CONSULTA A LA BD
        String sql = "SELECT NOMBRE FROM Lista_Precios ORDER BY NOMBRE ASC";
        
        try( 
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql)){
            
            while(rs.next()){
                listaPrecios.add(rs.getString("NOMBRE"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL CARGAR LAS LISTAS DE LA BASE DE DATOS" + e.getMessage(), "ERROR DE BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        for(String nombreLista : listaPrecios){
            modelo.addElement(nombreLista);
        }
        
       if(this.puntoVenta != null){
           actualizaListas();
       }
       
    }
    
    public void mostrarTabla(String tabla) {
        String sql = "SELECT * FROM " + tabla;

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("CODIGO");
        model.addColumn("NOMBRE");
        model.addColumn("RENTABILIDAD");
        lp.Tabla_ListaPrecios.setModel(model);

        String[] datos = new String[3];

        try {
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                model.addRow(datos);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR AL CARGAR LOS DATOS]: \n" + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "[ERROR EN EL FORMATO DE NUMEROS]: \n" + e.getMessage());
        }
    }

    public void agregar() {

        try {

            if (lp.Campo_NombreLP.getText().trim().isEmpty()
                    || lp.Campo_CodigoLP.getText().trim().isEmpty()
                    || lp.Campo_PorcentajeLP.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "TODOS LOS CAMPOS SON OBLIGATORIOS");
                return;
            }
            int codigo = Integer.parseInt(lp.Campo_CodigoLP.getText());
            double porcentaje = Double.parseDouble(lp.Campo_PorcentajeLP.getText());
//            if (codigo == Integer.parseInt(lp.Campo_CodigoLP.getText())) {
//                JOptionPane.showMessageDialog(null, "EL CODIGO YA SE ENCUENTRA REGISTRADO");
//                return;
//            }
            PreparedStatement agregar = con.prepareStatement("INSERT INTO Lista_Precios (CODIGO, NOMBRE, RENTABILIDAD) VALUES (?,?,?)");
            agregar.setInt(1, codigo);
            agregar.setString(2, lp.Campo_NombreLP.getText());
            agregar.setDouble(3, porcentaje);

            lp.Campo_CodigoLP.setText("");
            lp.Campo_NombreLP.setText("");
            lp.Campo_PorcentajeLP.setText("");
            agregar.executeUpdate();

            lp.Campo_CodigoLP.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: POR FAVOR INGRESE DATOS VALIDOS EN LOS CAMPOS\n" + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: " + e.getMessage());
        }
    }

    public void buscar() {
        try {
            PreparedStatement buscar = con.prepareStatement("SELECT * FROM Lista_Precios WHERE CODIGO = ?");
            buscar.setString(1, lp.Campo_CodigoLP.getText());
            ResultSet rs = buscar.executeQuery();

            if (rs.next()) {
                lp.Campo_CodigoLP.setText(rs.getString("CODIGO"));
                lp.Campo_NombreLP.setText(rs.getString("NOMBRE"));
                lp.Campo_PorcentajeLP.setText(rs.getString("RENTABILIDAD"));
            } else {
                JOptionPane.showMessageDialog(null, "NO SE ENCONTRÓ NINGUN REGISTRO CON ESE CODIGO");
            }

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "[ERROR]: \n" + e.getMessage());
        }

    }

    public void eliminar() {
        try {
            PreparedStatement eliminar = con.prepareStatement("DELETE FROM Lista_Precios WHERE CODIGO = ?");
            eliminar.setString(1, lp.Campo_CodigoLP.getText());
            int eliminarFilas = eliminar.executeUpdate();
            if (eliminarFilas > 0) {
                JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO EXITOSAMENTE!!");
                lp.Campo_CodigoLP.setText("");
                lp.Campo_NombreLP.setText("");
                lp.Campo_PorcentajeLP.setText("");
            } else {
                if (eliminarFilas < 0) {
                    JOptionPane.showMessageDialog(null, "NO SE ENCONTRARON REGISTROS CON ESE CODIGO");

                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: \n" + e.getMessage());
        }
    }

    public void modificar() {
        try {
            PreparedStatement modificar = con.prepareStatement("UPDATE Lista_Precios set CODIGO = ?, NOMBRE = ?, RENTABILIDAD = ? ");
            modificar.setString(1, lp.Campo_CodigoLP.getText());
            modificar.setString(2, lp.Campo_NombreLP.getText());
            modificar.setString(3, lp.Campo_PorcentajeLP.getText());
            lp.Campo_CodigoLP.setText("");
            lp.Campo_NombreLP.setText("");
            lp.Campo_PorcentajeLP.setText("");
            int modificar2 = JOptionPane.showConfirmDialog(null, "¿DESEA MODIFICAR LA LISTA?");
            if(modificar2 == 0 ){
                int fila = modificar.executeUpdate();
            if(fila != 0){
                modificar.executeUpdate();
                lp.Campo_CodigoLP.setText("");
                lp.Campo_NombreLP.setText("");
                lp.Campo_PorcentajeLP.setText("");
            }
            JOptionPane.showMessageDialog(null, "REGISTRO ACTUALIZADO CON EXITO!!");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"[ERROR]: \n" + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BtnAgregar) {
            agregar();
        }
        if (e.getSource() == BtnBuscar) {
            buscar();
        }
    }

}
