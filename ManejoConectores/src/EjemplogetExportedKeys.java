import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLOutput;

public class EjemplogetExportedKeys {
    public static void main(String[] args) {

        try {
            //Establecemos conexion con la BD
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/manejo_conectores", "root", "");

            //Creamos el objeto metadata
            java.sql.DatabaseMetaData dbmd = conexion.getMetaData();

            ResultSet resul = null;

            System.out.println("CLAVES foraneas que referencian a departamentos");
            System.out.println("===============================================");

            ResultSet fk = dbmd.getExportedKeys(null, "manejo_conectores", "departamentos");

            while(fk.next()){

                String fk_name = fk.getString("FKCOLUMN_NAME");
                String pk_name = fk.getString("PKCOLUMN_NAME");
                String pk_tablename = fk.getString("PKTABLE_NAME");
                String fk_tablename = fk.getString("FKTABLE_NAME");

                System.out.printf("Tabla: %s, Clave primaria: %s %n", fk_tablename, pk_name);
                System.out.println("Tabla FK: ");


            }


        } catch (Exception e) {

        }


    }

}
