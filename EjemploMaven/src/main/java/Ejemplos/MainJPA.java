package Ejemplos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MainJPA {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tienda");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Cliente c = new Cliente("Elida Diez", "elidiez@gmail.com", "632548963");
        em.persist(c);
        Cliente c2 = new Cliente("Dani", "danina@gmail.com", "632548963");
        em.persist(c2);

        tx.commit();
        em.close();
        emf.close();


    }

}
