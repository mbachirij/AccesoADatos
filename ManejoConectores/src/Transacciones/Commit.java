package Transacciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Commit {

    public static void main(String[] args){


        try {

            //Establecer conexion con la base de datos dinero
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/moha", "root", "");
            connection.setAutoCommit(false); //Desactivar el autocommit

            Statement sentencia = connection.createStatement();
            String sql1 = "INSERT INTO dinero (id, pers, end) VALUES (3, 'MOHA', 50)";
            //sentencia.executeUpdate(sql1); //Ejecutar la sentencia para insertar datos
            String sql = "SELECT * FROM dinero";
            ResultSet resul = sentencia.executeQuery(sql);
            // Recorremos el resultado para visualizar cada fila
            // Se hace un bucle mientras haya registros y se van visualizando
            while (resul.next()) {
                System.out.printf("%d, %s, %s %n",
                        resul.getInt(1),
                        resul.getString(2),
                        resul.getString(3));
            }



            connection.commit(); //Realizar el commit

            resul.close(); // Cerrar ResultSet
            sentencia.close(); // Cerrar Statement
            connection.close(); // Cerrar conexión


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
