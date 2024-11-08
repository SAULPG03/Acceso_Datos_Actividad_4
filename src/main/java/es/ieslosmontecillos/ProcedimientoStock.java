package es.ieslosmontecillos;

import java.sql.*;

public class ProcedimientoStock {

    public static int getStockArticulo(String nombreArticulo, String nombreFruteria) {
        int stock = 0;
        String pregunta= "{ ? = CALL stock_articulo(?, ?) }";
        try (Connection connection = conectar(); CallableStatement llamada = connection.prepareCall(pregunta)) {
            //Registramos el valor de retorno
            llamada.registerOutParameter(1, java.sql.Types.INTEGER);
            // Configuramos los parámetros de entrada
            llamada.setString(2, nombreArticulo);
            llamada.setString(3, nombreFruteria);
            //Ejecutamos la funcion
            llamada.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return stock;
    }
}
