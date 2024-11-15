package es.ieslosmontecillos;

import java.sql.*;

public class ProcedimientoStock {

    public static int getStockArticulo(String nombreArticulo, String nombreFruteria, Conectar conectar) {
        int stock = 0;
        String pregunta= "{ ? = CALL stock_articulo(?, ?) }";
        try (Connection connection = conectar.getConexion();
             CallableStatement llamada = connection.prepareCall(pregunta)) {
            //Registramos el valor de retorno
            llamada.registerOutParameter(1, java.sql.Types.INTEGER);
            // Configuramos los parámetros de entrada
            llamada.setString(2, nombreArticulo);
            llamada.setString(3, nombreFruteria);

            //Ejecutamos la funcion
            llamada.execute();

            //Obtenemos el valor devuleto por la funcion
            stock = llamada.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return stock;
    }
}
