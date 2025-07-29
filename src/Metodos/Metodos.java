package Metodos;

import GUI.INGRESO;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import gestor_ropa.BD_CONECCTION;
import javax.swing.JOptionPane;

public class Metodos {

    BD_CONECCTION bd1 = new BD_CONECCTION();
    Connection con1 = bd1.conectar();

    private String descripcion, referencia, observacion, talla, cantidad, costo;
    private int codigo;
//    private int cantidad;
//    private double costo;
    private INGRESO ingresos;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

// METODOS
    public void guardar() {

        if (ingresos == null) {
            ingresos = new INGRESO();

        }

        codigo = Integer.parseInt(ingresos.Campo_Codigo.getText());
        descripcion = ingresos.Campo_Descripcion.getText();
        referencia = ingresos.Campo_Referencia.getText();
        talla = ingresos.Campo_Talla.getText();
        observacion = ingresos.Campo_Observacion.getText();
        cantidad = ingresos.Campo_Cantidad.getText();
        costo = ingresos.Campo_Costo.getText();

        try {
            PreparedStatement guardar = con1.prepareStatement("INSERT INTO Ingresos (CODIGO, DESCRIPCION, REFERENCIA,TALLA, CANTIDAD, COSTO, FECHA_INGRESO, OBSERVACION) VALUES (?,?,?,?,?,?,?,?)");
            guardar.setInt(1, codigo);
            guardar.setString(2, descripcion);
            guardar.setString(3, referencia);
            guardar.setString(4, talla);
            guardar.setString(5, cantidad);
            guardar.setString(6, costo);
            guardar.setDate(7, new java.sql.Date(System.currentTimeMillis()));
            guardar.setString(8, observacion);

            //LIMPIAR CAMPOS
            ingresos.Campo_Cantidad.setText("");
            ingresos.Campo_Codigo.setText("");
            ingresos.Campo_Costo.setText("");
            ingresos.Campo_Descripcion.setText("");
            ingresos.Campo_Observacion.setText("");
            ingresos.Campo_Referencia.setText("");
            ingresos.Campo_Talla.setText("");
            guardar.executeUpdate();

            JOptionPane.showMessageDialog(null, "REGISTRADO");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: " + e);
        }

    }

}
