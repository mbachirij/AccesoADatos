package Practica2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Embebida {

    public static void main(String[] args){

        try {
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:embebida.db", "root", "");

            Statement sentencia = conexion.createStatement();

            sentencia.executeUpdate("CREATE TABLE IF NOT EXISTS Clientes (id INT PRIMARY KEY, nombre VARCHAR(255), email VARCHAR(255), tlf varchar(9))");

            sentencia.executeUpdate("INSERT INTO Clientes VALUES (10, 'Elida', 'elidiezdam01@gmail.com', '666666666')");
            sentencia.executeUpdate("INSERT INTO Clientes VALUES (12, 'Marcos', 'marcopoolo@gmail.com', '999999999')");
            sentencia.executeUpdate("INSERT INTO Clientes VALUES (14, 'Luis', 'luisa560@gmail.com', '222222222')");

            //Realizamos el commit
            conexion.commit();

            sentencia.close();
            conexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
