package gestor_ropa;

import java.sql.*;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class BD_CONECCTION {
    
    private static BD_CONECCTION instancia;
    private Connection con;

    static String url = "jdbc:mysql://localhost:3306/Gestor_Ropa";
    static String user = "root";
    static String pass = "costos";

    public BD_CONECCTION() { 
        try {
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión exitosa");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION: " + e.getMessage());
            con = null;
        }
    }
    
    public Connection getconectar(){
        return this.con;
    }
    
public static synchronized BD_CONECCTION getInstancia(){
    if(instancia == null){
        instancia = new BD_CONECCTION();
    }
    return instancia;
}
}
