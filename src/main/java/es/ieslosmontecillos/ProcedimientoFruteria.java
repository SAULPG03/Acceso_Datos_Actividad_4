package es.ieslosmontecillos;

import java.sql.*;

public class ProcedimientoFruteria {

    public static int getNumeroFruterias(String dni, Conectar conectar) {
        int numeroFruterias = 0;
        try (Connection connection = conectar.getConexion(); CallableStatement llamada = connection.prepareCall("{CALL numero_fruterias(?, ?)}")) {

            //Vamos a configuar el parametro de entrada
            llamada.setString(1, dni);

            //Vamos a registrar el parametro de salida
            llamada.registerOutParameter(2, Types.INTEGER);

            //Ejecutamos el procedimiento
            llamada.execute();

            //Obtenemos el valor del parametro de salida
            numeroFruterias = llamada.getInt(2);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return numeroFruterias;
    }
}

