import java.sql.*;

public class EjemploGetColumns {
    public static void main(String[] args) {

        try{
            //Establecemos conexion con la BD
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/manejo_conectores", "root", "");

            //Creamos un objeto metadata
            DatabaseMetaData dbmd = conexion.getMetaData();

            ResultSet resul = null;

            System.out.println("COLUMNAS DE LA TABLA DE DEPARTAMENTOS");
            System.out.println("===================================");

            ResultSet columnas = null;

            columnas = dbmd.getColumns(null, "ejemplo", "departamentos", null);

            while(columnas.next()){

                String nomCol = columnas.getString("COLUMN_NAME");
                String tipoCol = columnas.getString("TYPE_NAME");
                String tamCol = columnas.getString("COLUMN_SIZE");
                String nula = columnas.getString("IS_NULLABLE");

                System.out.printf("Columna: %s, Tipo: %s, Tamaño: %s, ¿Puede ser nula:? %s %n", nomCol, tipoCol, tamCol, nula);

            }

            //Cerrar conexion
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
