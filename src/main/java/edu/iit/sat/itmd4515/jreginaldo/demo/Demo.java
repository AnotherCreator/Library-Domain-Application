package edu.iit.sat.itmd4515.jreginaldo.demo;

import edu.iit.sat.itmd4515.jreginaldo.domain.Library;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("itmd4515testPU");
        Library library = new Library();

        library.setName("Avant-Garde Athenaeum");
        System.out.println(library);
    }
}
