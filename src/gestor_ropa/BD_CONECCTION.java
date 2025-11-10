package gestor_ropa;

import java.sql.*;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class BD_CONECCTION {
    
// 1. La instancia única (privada y estática)
    private static BD_CONECCTION instancia;

    // 2. El objeto Connection que se va a compartir
    private Connection connection;

    // 3. Tus credenciales de la base de datos
    // Modifica estos valores por los tuyos
    private static final String URL = "jdbc:mysql://localhost:3306/Gestor_Ropa";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "costos";

    // 4. El constructor ES PRIVADO
    // Esto previene que se creen nuevas instancias con "new ConexionSingleton()"
    BD_CONECCTION() {
        try {
            // El driver moderno de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establecer la conexión
            this.connection = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conexion Establecida");

        } catch (ClassNotFoundException e) {
            System.err.println("Error: Driver de MySQL no encontrado. " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos. " + e.getMessage());
        }
    }

    public static synchronized BD_CONECCTION getInstance() {
        
        if (instancia == null) {
            instancia = new BD_CONECCTION();
        }
          return instancia;
    }

    public Connection getconectar() {
        return this.connection;
    }

  
    public void cerrarConexion() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
                System.out.println("Conexion cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexion: " + e.getMessage());
        }
    }
}
