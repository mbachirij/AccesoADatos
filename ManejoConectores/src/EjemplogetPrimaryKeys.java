import java.sql.*;

public class EjemplogetPrimaryKeys {
    public static void main(String[] args) {

        try {
            //Establecemos conexion con la BD
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/manejo_conectores", "root", "");
            //Creamos un objeto metadata
            DatabaseMetaData dbmd = conexion.getMetaData();
            ResultSet resul = null;

            System.out.println("CLAVE PRIMARIA TABLA DEPARTAMENTOS");
            System.out.println("===================================");
            //Sacamos la lista de claves primarias de la tabla
            ResultSet pk = dbmd.getPrimaryKeys(null, "manejo_conectores", "departamentos");

            String pkDep="", separador="";
            //Recorremos el resultado para visualizar cada fila
            while(pk.next()){
                //Sacamos la clave primaria de la tabla
                pkDep = pkDep + separador + pk.getString("COLUMN_NAME");
                separador = "+";

            }

            System.out.println("Clave primaria: " + pkDep);

            conexion.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
