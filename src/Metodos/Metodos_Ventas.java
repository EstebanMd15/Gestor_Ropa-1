
package Metodos;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import GUI.Ventas;
import gestor_ropa.BD_CONECCTION;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;


public class Metodos_Ventas implements ActionListener{
    BD_CONECCTION bd = new BD_CONECCTION();
    Connection con = bd.conectar();
    
    private Ventas vt;
    private JButton btnBuscar;
    private JButton btnLimpiar;
    private JButton btnCancelar;
    private JButton btnAgregar;
    private JTable tabla_ventas;

    public Metodos_Ventas(Ventas vt) {
        this.vt = vt;
        this.btnAgregar = this.vt.BTN_AgregarVenta;
        this.btnBuscar = this.vt.BTN_BuscarVenta;
        this.btnCancelar = this.vt.BTN_CancelarVenta;
        this.btnLimpiar = this.vt.BTN_LimpiarVenta;
       
        
    }
    
    public void buscar(){
        try {
            PreparedStatement buscar = con.prepareStatement("SELECT * FROM Ingresos WHERE CODIGO = ?");
            buscar.setString(1, vt.Campo_CodigoVenta.getText());
            ResultSet rs = buscar.executeQuery();
            if(rs.next()){
                vt.Campo_DescripcionVenta.setText(rs.getString("DESCRIPCION"));
                vt.Campo_ReferenciaVenta.setText(rs.getString("REFERENCIA"));
                vt.Campo_TallaVenta.setText(rs.getString("TALLA"));
                vt.Campo_CostoVenta.setText(rs.getString("COSTO"));
                
            }else{
                JOptionPane.showMessageDialog(null, "NO SE ENCONTRO NINGUN REGISTRO CON ESE CODIGO");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"[ERROR]: " + e.getMessage());
                    
        }
    }
    
    public void agregarVenta(){
        try {
            PreparedStatement agregar = con.prepareStatement("INSERT INTO Ventas (CODIGO, DESCRIPCION, TALLA, REFERENCIA, COSTO, CANTIDAD) VALUES (?,?,?,?,?,?)");
            agregar.setString(1, vt.Campo_CodigoVenta.getText());
            agregar.setString(2, vt.Campo_DescripcionVenta.getText());
            agregar.setString(3, vt.Campo_TallaVenta.getText());
            agregar.setString(4, vt.Campo_ReferenciaVenta.getText());
            agregar.setString(5, vt.Campo_CostoVenta.getText());
            agregar.setString(6, vt.Campo_CantidadVenta.getText());
            
            vt.Campo_CodigoVenta.setText("");
            vt.Campo_DescripcionVenta.setText("");
            vt.Campo_TallaVenta.setText("");
            vt.Campo_ReferenciaVenta.setText("");
            vt.Campo_CantidadVenta.setText("");
            vt.Campo_CostoVenta.setText("");
            agregar.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"[ERROR]: " + e.getMessage());
        } 
    }
    
    public void limpiar(){
        vt.Campo_CostoVenta.setText("");
        vt.Campo_CodigoVenta.setText("");
        vt.Campo_DescripcionVenta.setText("");
        vt.Campo_ReferenciaVenta.setText("");
        vt.Campo_TallaVenta.setText("");
        vt.Campo_TotalVenta.setText("");
    }
    
    public void cancelar(){
        try {
            PreparedStatement cancelar = con.prepareStatement("TRUNCATE TABLE Ventas");
            cancelar.executeUpdate();
            JOptionPane.showMessageDialog(null, "REGISTROS ELIMINADOS CORRECTAMENTE");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "[ERROR]: " + e.getMessage());
        }
    }
    
        public void calcularYMostrarTotal(){
        DefaultTableModel model = (DefaultTableModel) vt.Tabla_Ventas.getModel();// SE OBTIENE EL MODELO DE DATOS DE LA TABLA
        
        double totalGeneral = 0.0;// se inicializa una variable para guardar la suma total
        
        for (int i = 0; i < model.getRowCount(); i++) {//se recorre todas las filas de la tabla
            try {
                String valorcelda = model.getValueAt(i, 6).toString();//se obtiene el valor de la columna "VALOR TOTAL", INDICE 6
                double subtotal = Double.parseDouble(valorcelda);//se convierte de objeto a String y luego a double para poder sumarlo
                
                totalGeneral += subtotal;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error al parsear el valor en la fila " + i + ":"+ e.getMessage());
            }
        }
        vt.Campo_TotalVenta.setText(String.format("%.2f", totalGeneral));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnBuscar){
            buscar();
        }
        if(e.getSource() == btnAgregar){
            agregarVenta();
        }
        if(e.getSource() == btnLimpiar){
            limpiar();
        }
        if (e.getSource() == btnCancelar) {
            cancelar();       
        }
    }
    
    
}
