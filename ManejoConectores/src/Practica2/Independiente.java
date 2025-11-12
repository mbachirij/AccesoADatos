package Practica2;

import java.sql.*;

public class Independiente {
    public static void main(String[] args){

        try{
            //Conectar con la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/independiente", "root", "");

            //Crear sentencia
            Statement sentencia = conexion.createStatement();
            //Ejecutar sentencia para crear los campos
            sentencia.executeUpdate("CREATE TABLE IF NOT EXISTS Clientes (id INT PRIMARY KEY, nombre VARCHAR(255), email VARCHAR(255), tlf varchar(9))");
            //Ejecutar sentencia para insertar al menos 3 registros
            sentencia.executeUpdate("INSERT INTO Clientes VALUES (10, 'Mohammed', 'mbj01@gmail.com', '666666666')");
            sentencia.executeUpdate("INSERT INTO Clientes VALUES (12, 'Ignacio', 'igumnt@gmail.com', '999999999')");
            sentencia.executeUpdate("INSERT INTO Clientes VALUES (14, 'Oscar', 'oscar560@gmail.com', '222222222')");

            String sql = "SELECT * FROM Clientes";
            ResultSet resul = sentencia.executeQuery(sql);

            while(resul.next()){
                System.out.println(resul.getInt(1) + " " + resul.getString(2) + " " + resul.getString(3) + " " + resul.getString(4));
            }

            conexion.commit();

            resul.close();
            sentencia.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
