package edu.iit.sat.itmd4515.jreginaldo.demo;

import edu.iit.sat.itmd4515.jreginaldo.domain.Library;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("itmd4515testPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Library library = new Library();

        library.setName("Avant-Garde Athenaeum");
        System.out.println(library);

        em.persist(library);
        tx.commit();
    }
}
