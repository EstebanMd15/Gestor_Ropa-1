package gestor_ropa;

import java.sql.*;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class BD_CONECCTION {

    static String url = "jdbc:mysql://localhost:3306/Gestor_Ropa";
    static String user = "root";
    static String pass = "costos";

    public static Connection conectar() {
        Connection con1 = null;
        try {
            con1 = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión exitosa");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION: " + e.getMessage());
        }
        return con1;
    }

}
