package Metodos;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import gestor_ropa.BD_CONECCTION;
import GUI.INGRESO;
import GUI.Lista_Precios;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Metodos_ListaPrecios implements ActionListener {

    BD_CONECCTION bd = new BD_CONECCTION();
    Connection con = bd.conectar();
    INGRESO ig = new INGRESO();
    Lista_Precios lp = new Lista_Precios();

    private JButton BtnAgregar;
    private JButton BtnBuscar;
    private JButton BtnEliminar;
    private JButton BtnModificar;
    private JButton BtnMostrar;
    private JButton BtnSalir;

    private double lista1 = 1.25;
    private double lista2 = 1.35;
    private double lista3 = 1.45;

    public Metodos_ListaPrecios(Lista_Precios lp) {
        this.lp = lp;
        this.BtnAgregar = this.lp.Btn_AgregarLP;
        this.BtnBuscar = this.lp.Btn_BuscarLP;
        this.BtnEliminar = this.lp.Btn_EliminarLP;
        this.BtnModificar = this.lp.Btn_ModificarLP;
        this.BtnMostrar = this.lp.Btn_MostrarLP;
        this.BtnSalir = this.lp.Btn_SalirLP;
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

    public Metodos_ListaPrecios() {
        this.lista1 = lista1;
        this.lista2 = lista2;
        this.lista3 = lista3;

    }

    public void agregar() {
  
        try {
            int codigo = Integer.parseInt(lp.Campo_CodigoLP.getText());
            double porcentaje = Double.parseDouble(lp.Campo_PorcentajeLP.getText());
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BtnAgregar) {
            agregar();
        }
    }

}
