package es.ieslosmontecillos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
    private Connection conexion;

    // Constructor para establecer la conexión con la base de datos MySQL
    public Conectar(String url, String usuario, String password) throws SQLException {
        try {
            // Registrar el controlador de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            this.conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión establecida con la base de datos.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encuentra el driver de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
            throw e;
        }
    }

    // Metodo para obtener la conexión
    public Connection getConexion() {
        return conexion;
    }

    // Metodo para cerrar la conexión
    public void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión.");
                e.printStackTrace();
            }
        }
    }
}
