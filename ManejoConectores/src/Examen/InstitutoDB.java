package Examen;

import java.sql.*;
import java.util.Scanner;
/*
 * Mohammed Bachiri Jabbouri
 */
public class InstitutoDB {
    public static void main(String[] args) {

        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/InstitutoBD", "root", "");

            // Apartado: A
            crearTablas(conexion);

            // Apartado: B
            pedirUser(conexion);

            // Apartado: C
            mostrarAlumnos(conexion);

            // Apartado: D
            metaData(conexion);

            // Apartado: E
            insertarAlumnoNuevoCurso(conexion);

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public static void insertarAlumnoNuevoCurso(Connection con) {
        try {
            con.setAutoCommit(false);

            PreparedStatement curso = con.prepareStatement(
                    "INSERT INTO Curso VALUES (999, 'CursoNuevo', 100)");
            curso.executeUpdate();

            try {
                PreparedStatement alumno = con.prepareStatement(
                        "INSERT INTO Alumno VALUES (?,?,?, ?,999)");

                alumno.setInt(1, 1);
                alumno.setString(2, "Juan");
                alumno.setInt(3, 20);
                alumno.setDouble(4, 7.5);
                alumno.executeUpdate();

                alumno.setInt(1, 2);
                alumno.setString(2, "Maria");
                alumno.setInt(3, 21);
                alumno.setDouble(4, 8.1);
                alumno.executeUpdate();

                alumno.setInt(1, 3);
                alumno.setString(2, "Pedro");
                alumno.setInt(3, 22);
                alumno.setDouble(4, 6.9);
                alumno.executeUpdate();

                con.commit();
                System.out.println("Curso con los alumnos insertado correctamente.");

            } catch (Exception ex) {
                con.rollback();
                System.out.println("Curso sin alumnos insertado correctamente.");
            }

        } catch (SQLException e) {
            System.out.println("Error en transacción: ");
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException ignored) {}
        }
    }

    public static void metaData(Connection conexion) {

        try {
            DatabaseMetaData metaData = conexion.getMetaData();

            ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"});

            while (tables.next()) {
                System.out.println(tables.getString("TABLE_NAME"));
                System.out.println("Tabla "+tables.getString("TABLE_NAME")+"\n");



            }


        } catch (SQLException e) {
            System.out.println("Erroor. No se pudo obtener la meta data");
            e.getMessage();
        }


    }

    public static void mostrarAlumnos(Connection conexion) {
        Scanner sc = new Scanner(System.in);
        System.out.print("ID del alumno: ");
        int id = sc.nextInt();

        try {
            PreparedStatement pst = conexion.prepareStatement(
                    "SELECT a.idAlumno, a.nombre, a.edad, a.nota_media, a.idCurso, " +
                            "c.nombre AS nombreCurso " +
                            "FROM Alumno a JOIN Curso c ON a.idCurso = c.idCurso " +
                            "WHERE a.idAlumno = ?");

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("[Alumno " + rs.getInt("idAlumno") + "] "
                        + rs.getString("nombre") + " (" + rs.getInt("edad") + ") - "
                        + "Nota: " + rs.getDouble("nota_media") + " - "
                        + "Curso: " + rs.getString("nombreCurso")
                        + " (id=" + rs.getInt("idCurso") + ")");
            } else {
                System.out.println("No existe el alumno.");
            }

        } catch (SQLException e) {
            System.out.println("Error mostrando alumno: " + e.getMessage());
        }
    }

    public static void pedirUser(Connection conexion) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el idCurso: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Escribe el nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Escribe las horas: ");
        String horas = sc.nextLine();
        try {

            PreparedStatement comprob = conexion.prepareStatement("SELECT * FROM Curso WHERE idCurso = ?");
            comprob.setInt(1, id);

            ResultSet resultSet = comprob.executeQuery();

            if (resultSet.next()) {
                System.out.println("El curso con este id ya existe. No se inserta nada");
            }

            PreparedStatement ps = conexion.prepareStatement("INSERT INTO Curso VALUES (?, ?, ?)");
            ps.setInt(1, id);

            ps.setString(2, nombre);
            ps.setString(3, horas);

            int filas = ps.executeUpdate();
            System.out.println("Filas insertadas: " + filas);

        } catch (SQLException e) {
            System.out.println("Error al comprobar el curso: ");
            e.getMessage();
        }

    }

    public static void crearTablas(Connection conexion) {

        try {
            Statement statement = conexion.createStatement();

            String sqlCurso = "CREATE TABLE IF NOT EXISTS Curso (" +
                    "idCurso int PRIMARY KEY not null, " +
                    "nombreCurso VARCHAR(50) not null, " +
                    "horas INT not null))";
            statement.executeUpdate(sqlCurso);

            String sqlAlumno = "CREATE TABLE IF NOT EXISTS Alumno (" +
                    "idAlumno int PRIMARY KEY, " +
                    "nombre VARCHAR(50) not null, " +
                    "edad INT, " +
                    "nota_media DOUBLE, " +
                    "idCurso INT, " +
                    "FOREIGN KEY (idCurso) REFERENCES Curso(idCurso))";
            statement.executeUpdate(sqlAlumno);

        } catch (SQLException e) {
            System.out.println("Error al crear las tablas: ");
            e.getMessage();
        }

    }

}
