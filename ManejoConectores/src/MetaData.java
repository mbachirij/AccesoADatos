import java.sql.*;

public class MetaData {
    public static void main(String[] args) {

        try {
            //Creamos una conexion con la BD
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/manejo_conectores", "root", "");

            //Creamos un objeto metadata
            DatabaseMetaData dbmd = conexion.getMetaData();

            //Obtenemos la lista de tablas de la BD
            ResultSet resul = null;

            String nombre = dbmd.getDatabaseProductName();
            String driver = dbmd.getDriverName();
            String usuario = dbmd.getUserName();
            String url = dbmd.getURL();

            System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS:");
            System.out.println("===================================");
            System.out.println("Nombre de la BD: " + nombre);
            System.out.println("Nombre del driver: " + driver);
            System.out.println("URL: " + url);
            System.out.println("Usuario: " + usuario);

            //Obtenemos información de las tablas y vistas que hay
            resul = dbmd.getTables(null, "ejemplo", null, null);

            while(resul.next()){
                String catalogo = resul.getNString(1);//columna 1
                String esquema = resul.getNString(2);//columna 2
                String tabla = resul.getNString(3);//columna 3
                String tipo = resul.getNString(4);//columna 4

                System.out.printf("Catálogo: %s, Esquema: %s, Tabla: %s, Tipo: %s %n", catalogo, esquema, tabla, tipo);
            }
            //Cerrar conexion
            conexion.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
