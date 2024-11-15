package es.ieslosmontecillos;

import java.sql.*;
import java.util.Scanner;

public class Actividad_4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Parámetros de conexión
        String url = "jdbc:mysql://localhost:3306/tiendas";
        String usuario = "root";
        String password = "usuario";

        // Crear instancia de Conectar
        Conectar conectar = null;
        try {
            conectar = new Conectar(url, usuario, password);
        } catch (SQLException e) {
            System.out.println("No se pudo establecer la conexión con la base de datos.");
            e.printStackTrace();
            return;
        }

        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Ejecutar procedimiento numero_fruterias");
            System.out.println("2. Ejecutar función stock_articulo");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    ejecutarNumeroFruterias(scanner,conectar);
                    break;

                case 2:
                    ejecutarStockArticulo(scanner,conectar);
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida, por favor seleccione una opción válida.");
            }

        } while (opcion != 3);

        scanner.close();
    }

    private static void ejecutarNumeroFruterias(Scanner scanner1,Conectar conectar) {
        System.out.print("Ingrese el DNI del empresario: ");
        String dni = scanner1.nextLine();

        int numeroFruterias = ProcedimientoFruteria.getNumeroFruterias(dni,conectar);
        System.out.println("Número de fruterías para el empresario con DNI " + dni + ": " + numeroFruterias);
    }

    private static void ejecutarStockArticulo(Scanner scanner,Conectar conectar) {
        System.out.print("Ingrese el nombre del artículo: ");
        String nombreArticulo = scanner.nextLine();

        System.out.print("Ingrese el nombre de la frutería: ");
        String nombreFruteria = scanner.nextLine();

        int stock = ProcedimientoStock.getStockArticulo(nombreArticulo, nombreFruteria,conectar);
        if(stock==0){
            System.out.println("EL ARTÍCULO "+nombreArticulo+" NO ESTÁ EN STOCK EN LA FRUTERÍA "+nombreFruteria);
        }
        else {
            System.out.println("Stock del artículo " + nombreArticulo + " en " + nombreFruteria + ": " + stock);
        }
    }
}
