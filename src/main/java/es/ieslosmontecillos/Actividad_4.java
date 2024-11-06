package es.ieslosmontecillos;

import java.sql.*;
import java.util.Scanner;

public class Actividad_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/tiendas";
        String usuario = "root";  // Cambia por tu usuario de MySQL
        String password = "usuario"; // Cambia por tu contraseña de MySQL
        int opcion=0;

        try {
            // Crear una instancia de la clase Conectar
            Conectar conexionBD = new Conectar(url, usuario, password);
            // Usar la conexión para ejecutar consultas...
            Connection conn = conexionBD.getConexion();
            System.out.println("------------MENU-------------");
            System.out.println("1. Insertar Articulo");
            System.out.println("2. Insertar Empresario");
            System.out.println("3. Insertar Fruteria");
            System.out.println("4. Insertar Registros en la tabla Stock");
            System.out.println("5. Mostrar las fruterias de un empleado,mostramos nombre DNI, nombre del empresario y nombre de la fruteria");
            System.out.println("6. Mostrar para una fruteria, el stock que tiene disponible. Mostramos nombre de la fruteria, nombre del articulo, tipo del articulo y cantidad en stock.");
            System.out.println("Introduce una opcion: ");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:
                    /*
                    Cambiarlo para que lo pida todo por teclado
                     */
                    Integer codigo=20;
                    String articulo="Platano";
                    String categoria="Fruta";
                    Double precio=9.5;
                    //insertarArticulo(conn,codigo,articulo,categoria,precio,sc);
                    break;
                case 2:
                    String DNI="25034786F";
                    String nombre="Platano";
                    Integer telefono=675332818;
                    //insertarEmpresario(conn,DNI,nombre,telefono,sc);
                    break;
                case 3:
                    Integer cod=60;
                    String nombe="FRUTERIA PAPAYA";
                    String direccion="Avda Diego Reina Sofia,23";
                    Integer tfno=675332818;
                    String codempresario="33396348W";
                    //insertarFruteria(conn,cod,nombe,direccion,tfno,codempresario,sc);
                    break;
                case 4:
                    Integer codart=1;
                    Integer codfamilia=50;
                    Integer cantidad=300;
                    //insertarStock(conn,codart,codfamilia,cantidad,sc);
                    break;
                case 5:
                    String DNIEmpresario="25034786L";
                    //mostrarFruteriasEmpleados(conn,DNIEmpresario,sc);
                    break;
                default:
                    System.out.println("Has introducido un numero invalido");
                    break;

            }


            // Cerrar la conexión cuando ya no sea necesaria
            conexionBD.cerrarConexion();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}