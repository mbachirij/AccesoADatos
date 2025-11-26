package org.example;

import org.example.Alumno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;

public class AppHibernateJPA {
    public static void main(String[] args) {

        // 1. Crear la fábrica de gestoeres de entidades
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EscuelaPU");

        // 2. Crear un EntityManager (equivale a Session)
        EntityManager em = emf.createEntityManager();

        // 3. Iniciar transacción
        EntityTransaction tx = em.getTransaction();

        // 4. Crear y persistir un nuevo Alumno
        Alumno alumno = new Alumno("Juan", "juan669@gmail.com");
        em.persist(alumno);

        // 5. Confirmar transacción
        tx.commit();

        // 6. Consultar todos los Alumnos
        List<Alumno> lista = em.createQuery("SELECT a FROM Alumno a", Alumno.class).getResultList();
        lista.forEach(System.out::println);

        // 7. Cerrar recursos
        em.close();
        emf.close();


    }
}
