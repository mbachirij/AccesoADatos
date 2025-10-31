package Transacciones;

import java.sql.*;

public class Savepoint {
    public static void main(String[] args) {

        String sql1 = "INSERT INTO `moha`.`dinero` (id, pers, end) VALUES (?, ?, ?)";
        String sql2 = "INSERT INTO `moha`.`dinero` (id, pers, end) VALUES (?, ?, ?)";

        Connection con = null;

        try {
            // Conexión a la base de datos
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moha", "root", "");
            con.setAutoCommit(false); // Desactivar autocommit

            // Primera inserción
            PreparedStatement ps = con.prepareStatement(sql1);
            ps.setInt(1, 10);          // ID único
            ps.setString(2, "LUIS");
            ps.setInt(3, 80);
            ps.executeUpdate();
            ps.close();

            // Crear savepoint después del primer insert
            Savepoint sp = (Savepoint) con.setSavepoint("DespuesPrimerInsert");

            // Segunda inserción (forzando error: ID duplicado)
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, 10);         // ID duplicado para generar excepción
            ps2.setString(2, "MARIA");
            ps2.setInt(3, 50);

            try {
                ps2.executeUpdate();
                System.out.println("✅ Segunda inserción correcta");
            } catch (SQLException e) {
                System.out.println("⚠️ Error en segunda inserción, rollback al savepoint");
                e.printStackTrace();
                con.rollback(sp); // Revierte solo la segunda inserción
            }
            ps2.close();

            // Confirmar la transacción
            con.commit();
            System.out.println("✅ Transacción completada correctamente");

        } catch (SQLException e) {
            System.out.println("❌ Error en la transacción completa");
            e.printStackTrace();
            try {
                if (con != null) con.rollback(); // Rollback total si falla algo fuera del savepoint
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
