package Metodos;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import GUI.Ventas;
import GUI.INGRESO;
import GUI.Inventario;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
//import com.mysql.cj.protocol.Resultset;
import gestor_ropa.BD_CONECCTION;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTextField;
import java.util.List;

public class Metodos_Ventas implements ActionListener {

    BD_CONECCTION bd = new BD_CONECCTION();
    Connection con = bd.conectar();
    INGRESO ig = new INGRESO();
    Ventas vt = new Ventas();
    Inventario in = new Inventario();
    private JButton btnBuscar;
    private JButton btnLimpiar;
    private JButton btnCancelar;
    private JButton btnAgregar;
    private JButton btnVender;
    private JTable tabla_ventas;
    private int CantDispo;

    public Metodos_Ventas(Ventas vt) {
        this.vt = vt;
        this.btnAgregar = this.vt.BTN_AgregarVenta;
        this.btnBuscar = this.vt.BTN_BuscarVenta;
        this.btnCancelar = this.vt.BTN_CancelarVenta;
        this.btnLimpiar = this.vt.BTN_LimpiarVenta;
        this.btnVender = this.vt.BTN_VenderVenta;

    }

    public void buscar() {
        try {
            PreparedStatement buscar = con.prepareStatement("SELECT * FROM INGRESOS WHERE CODIGO_I = ?");
            buscar.setString(1, vt.Campo_CodigoVenta.getText());
            ResultSet rs = buscar.executeQuery();
            if (rs.next()) {
                vt.Campo_DescripcionVenta.setText(rs.getString("DESCRIPCION"));
                vt.Campo_ReferenciaVenta.setText(rs.getString("REFERENCIA"));
                vt.Campo_TallaVenta.setText(rs.getString("TALLA"));
                vt.Campo_COSTOventa.setText(rs.getString("COSTO"));
                vt.Campo_PrecioVenta1.setText(rs.getString("PRECIO"));

                this.CantDispo = rs.getInt("CANTIDAD");
            } else {
                JOptionPane.showMessageDialog(null, "NO SE ENCONTRO NINGUN REGISTRO CON ESE CODIGO");
                this.CantDispo = 0;
                limpiar();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: " + e.getMessage());

        }
    }

    public void cantidadDispo() {
        try {
            PreparedStatement cant = con.prepareStatement("SELECT * FROM INGRESOS WHERE CODIGO_I = ?");
            cant.setString(1, vt.Campo_CodigoVenta.getText());
            ResultSet rs = cant.executeQuery();
            if (rs.next()) {
                vt.Campo_CantDispo.setText(rs.getString("CANTIDAD"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: " + e.getMessage());
        }
    }

    private int generarConsecutivo() {
        DefaultTableModel model = (DefaultTableModel) vt.Tabla_Ventas.getModel();
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
        try (PreparedStatement stmt = con.prepareStatement(obtenerConsecutivoSQL);
             ResultSet rs = stmt.executeQuery()) {
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
    public void agregarVenta() {

        String cantV = vt.Campo_CantidadVenta.getText().trim();
        int cantidadVender = Integer.parseInt(cantV);

//        try {
//            int facturaId = generarConsecutivo();
//
//            PreparedStatement factura = con.prepareStatement("INSERT INTO FACTURA_PRODUCTOS (FACTURA_ID, NOMBRE_PRODUCTO, REFERENCIA, TALLA, CANTIDAD, PRECIO_UNITARIO, TOTAL) VALUES (?,?,?,?,?,?,?");
//            factura.setInt(1, facturaId);
//            factura.setString(2, vt.Campo_DescripcionVenta.getText());
//            factura.setString(3, vt.Campo_ReferenciaVenta.getText());
//            factura.setString(4, vt.Campo_TallaVenta.getText());
//            factura.setString(5, vt.Campo_CantidadVenta.getText());
//            factura.setString(6, vt.Campo_PrecioVenta1.getText());
//            factura.setString(7, vt.Campo_TotalVenta.getText());
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null,"[ERROR]: " + e.getMessage());
//        }

        try {

            String codigo = vt.Campo_CodigoVenta.getText();
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
                vt.Campo_CantidadVenta.requestFocus();
                return;
            }

            //SE COMPARA EL STOCK DISPONIBLE
            PreparedStatement buscar = con.prepareStatement("SELECT* FROM INGRESOS WHERE CODIGO_I = ?");
            buscar.setString(1, codigo);
            ResultSet rs = buscar.executeQuery();
            if (rs.next()) {
                this.CantDispo = rs.getInt("CANTIDAD");

            }
            if (cantidadVender > this.CantDispo) {
                JOptionPane.showMessageDialog(null, "NO CUENTA CON LA CANTIDAD SUFICIENTE\nCANTIDAD DISPONIBLE: " + this.CantDispo);
                vt.Campo_CantidadVenta.requestFocus();

                return;// se detiene la ejecucion del método
            }

            PreparedStatement agregar = con.prepareStatement("INSERT INTO VENTAS (CODIGO_V, DESCRIPCION, TALLA, REFERENCIA, PRECIO, CANTIDAD) VALUES (?,?,?,?,?,?)");
            agregar.setString(1, vt.Campo_CodigoVenta.getText());
            agregar.setString(2, vt.Campo_DescripcionVenta.getText());
            agregar.setString(3, vt.Campo_TallaVenta.getText());
            agregar.setString(4, vt.Campo_ReferenciaVenta.getText());
            agregar.setString(5, vt.Campo_PrecioVenta1.getText());
            agregar.setString(6, vt.Campo_CantidadVenta.getText());

            vt.Campo_CodigoVenta.setText("");
            vt.Campo_DescripcionVenta.setText("");
            vt.Campo_TallaVenta.setText("");
            vt.Campo_ReferenciaVenta.setText("");
            vt.Campo_CantidadVenta.setText("");
            vt.Campo_COSTOventa.setText("");
            agregar.executeUpdate();

            //Se reinicia la cantidad disponible para la proxima busqueda
            this.CantDispo = 0;
            vt.Campo_CodigoVenta.requestFocus();// foco en el campo del código
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE UN NUMERO VALIDO EN EL CAMPO DE CANTIDAD");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: " + e.getMessage());
        }
    }

    public void limpiar() {
        vt.Campo_COSTOventa.setText("");
        vt.Campo_CodigoVenta.setText("");
        vt.Campo_DescripcionVenta.setText("");
        vt.Campo_ReferenciaVenta.setText("");
        vt.Campo_TallaVenta.setText("");
        vt.Campo_TotalVenta.setText("");
        vt.Campo_CantidadVenta.setText("");
        vt.Campo_TotalVenta.setText("");
        vt.Campo_CantDispo.setText("");
        vt.Campo_PrecioVenta1.setText("");

    }

    public void limpiar2() {
        vt.Campo_CodigoVenta.setText("");
        vt.Campo_CantidadVenta.setText("");
        vt.Campo_PrecioVenta1.setText("");
        vt.Campo_COSTOventa.setText("");
        vt.Campo_DescripcionVenta.setText("");
        vt.Campo_TallaVenta.setText("");
        vt.Campo_ReferenciaVenta.setText("");
        vt.Campo_CantDispo.setText("");
    }

    public void cancelar() {
        try {
            PreparedStatement cancelar = con.prepareStatement("TRUNCATE TABLE VENTAS");
            cancelar.executeUpdate();
            JOptionPane.showMessageDialog(null, "REGISTROS ELIMINADOS CORRECTAMENTE");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: " + e.getMessage());
        }
    }

    public void calcularYMostrarTotal() {
        DefaultTableModel model = (DefaultTableModel) vt.Tabla_Ventas.getModel();// SE OBTIENE EL MODELO DE DATOS DE LA TABLA

        double totalGeneral = 0.0;// se inicializa una variable para guardar la suma total

        for (int i = 0; i < model.getRowCount(); i++) {//se recorre todas las filas de la tabla
            try {
                String valorcelda = model.getValueAt(i, 6).toString();//se obtiene el valor de la columna "VALOR TOTAL", INDICE 6
                double subtotal = Double.parseDouble(valorcelda);//se convierte de objeto a String y luego a double para poder sumarlo

                totalGeneral += subtotal;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error al parsear el valor en la fila " + i + ":" + e.getMessage());
            }
        }
        vt.Campo_TotalVenta.setText(String.format("%.2f", totalGeneral));
    }
    
    public void obtenerProductos(){
        DefaultTableModel model = (DefaultTableModel) vt.Tabla_Ventas.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            try {
                String id = model.getValueAt(i, 0).toString();
                PreparedStatement obt = con.prepareStatement("INSERT INTO FACTURA_PRODUCTOS(FACTURA_ID) VALUES (?)");
                obt.setString(1, id);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"[ERROR]: " + e);
            }
            
        }
    }

    public void venderVentas() {
        //Se prepara la consulta SQL
        String selecVentas = "SELECT CODIGO_V, CANTIDAD FROM VENTAS";
        String actualizarInventario = "UPDATE INGRESOS SET CANTIDAD = CANTIDAD - ? WHERE CODIGO_I = ?";

        try {
            // Se inicia una transaccion para asegurar la integridad de los datos
            con.setAutoCommit(false);
            //se obtiene los productos de la tabla venta actual
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(selecVentas);
            //se prepara la consulta para actualizar el inventario
            PreparedStatement actualizar = con.prepareStatement(actualizarInventario);
            //Se recorre cada producto vendido y se actualiza el inventario
            while (rs.next()) {
                String codigo = rs.getString("CODIGO_V");
                int cantidadVendida = rs.getInt("CANTIDAD");
                actualizar.setInt(1, cantidadVendida);
                actualizar.setString(2, codigo);

                if (codigo.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "EL CAMPO CODIGO NO PUEDE ESTAR VACIO");
                }

                actualizar.executeUpdate();// se ejecuta la resta del stock
            }

            //Si el proceso salió bien, se confirma los cambios en la base de datos
            con.commit();
            JOptionPane.showMessageDialog(null, "VENTA REALIZADA CON EXITO!!\n INVENTARIO ACTUALIZADO");
            //Se actualiza la tabla para que se vea vacía
            DefaultTableModel model = (DefaultTableModel) vt.Tabla_Ventas.getModel();
            model.setRowCount(0);
        } catch (SQLException e) {
            //si algo sale mal, se deshace todos los cambios 
            try {
                con.rollback();
                JOptionPane.showMessageDialog(null, "ERROR EN LA TRANSACCION\n LA VENTA A SIDO REVERTIDA" + e.getMessage());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL REVERTIR LA TRANSACCION\n [ERROR]: " + ex.getMessage());
            }
        } finally {
            //Se deja la conexion como estaba para realizar otras operaciones
            try {
                con.setAutoCommit(true);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR AL RESTAURAR LA CONEXION: " + e.getMessage());
            }
        }
        cancelar();
        limpiar();
    }

    public void calculoPorcentaje() {
        try {
            double costoBase = 0;

            PreparedStatement porc = con.prepareStatement("SELECT *  FROM INGRESOS WHERE CODIGO_I = ?");
            porc.setString(1, ig.Campo_Codigo.getText());
            ResultSet rs = porc.executeQuery();

            if (rs.next()) {
                String costoBD = rs.getString("COSTO");
                if (costoBD != null && !costoBD.isEmpty()) {
                    costoBase = Double.parseDouble(costoBD);
                    ig.Campo_Costo.setText(costoBD);
                }
            } else {
                String costoInve = vt.Campo_COSTOventa.getText();
                if (costoInve != null && !costoInve.isEmpty()) {
                    costoBase = Double.parseDouble(costoInve);
                }
            }

            double precioFinal;

            if (costoBase > 5000) {
                precioFinal = costoBase * 1.30;
            } else {
                precioFinal = costoBase;
            }
            vt.Campo_PrecioVenta1.setText(String.valueOf(precioFinal));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]:\n" + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "[ERROR EN EL FORMATO]: VERIFIQUE QUE LOS CAMPOS TENGAN VALORES VALIDOS\n" + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: \n" + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBuscar) {
            buscar();
        }
        if (e.getSource() == btnAgregar) {
            agregarVenta();
        }
        if (e.getSource() == btnLimpiar) {
            limpiar();
        }
        if (e.getSource() == btnCancelar) {
            cancelar();
        }
        if (e.getSource() == btnVender) {
            venderVentas();
        }

    }
}
