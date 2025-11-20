package EjercicioJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejer1 {
    public static void main(String[] args) {

        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/gestion_personas" +
                    "", "root", "");

            //Crear sentencia
            Statement sentencia = conexion.createStatement();
            // Ejecutar sentencia, El AUTO_INCREMENT es para que se ponga solo el id así no hay que inventarse uno cada vez
            String sqlDep = "CREATE TABLE IF NOT EXISTS Dep ("+
                            "id INT PRIMARY KEY AUTO_INCREMENT, "+
                            "numDep INT, "+
                            "nombre VARCHAR(50), "+
                            "ala VARCHAR(50))";

            sentencia.executeUpdate(sqlDep);
            System.out.println("Tabla 'Dep' creada correctamente");

            String sqlPer = "CREATE TABLE IF NOT EXISTS Persona ("+
                            "dni VARCHAR(9) PRIMARY KEY, "+
                            "nombre VARCHAR(50), "+
                            "apellido VARCHAR(50), "+
                            "edad INT, "+
                            "numDep INT, "+
                            "FOREIGN KEY (numDep) REFERENCES Dep(id))";

            sentencia.executeUpdate(sqlPer);
            System.out.println("Tabla 'Persona' creada correctamente");

            String dep1 = "INSERT INTO Dep VALUES (NULL, 20, 'Redes Sociales', 'Ala Norte')";
            sentencia.executeUpdate(dep1);
            String per1 = "INSERT INTO Persona VALUES ('11132467M', 'Elida', 'Diez', 37, 1)";
            sentencia.executeUpdate(per1);



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
