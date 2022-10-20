package edu.iit.sat.itmd4515.jreginaldo.domain;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.Month;

public class LibraryJPATest extends AbstractJPATest{
    @Test
    public void createTest() {
        Library createTest = new Library("createTest", "TestAddress", "123-123-1234", LocalDate.now());

        // Begin insertion sequence
        tx.begin();
        em.persist(createTest);
        tx.commit();

        // Make sure row was successfully inserted
        assertNotNull(createTest.getId());

        // Find newly updated row
        Library compareTest = em.find(Library.class, createTest.getId());
        assertEquals(compareTest.getPhoneNum(), createTest.getPhoneNum());

        // Begin cleanup sequence
        tx.begin();
        em.remove(createTest);
        tx.commit();
    }

    @Test
    public void readTest() {
        Library readTest = em.createQuery(
                "SELECT l FROM Library l WHERE l.name = 'libraryTest'", Library.class).getSingleResult();
        assertEquals("libraryTest", readTest.getName());
    }

    @Test
    public void updateTest() {
        Library updateTest = em.createQuery(
                "SELECT l FROM Library l WHERE l.name = 'libraryTest'", Library.class).getSingleResult();

        // Begin update sequence
        tx.begin();
        updateTest.setStreetAdd("libraryUpdate");
        updateTest.setPhoneNum("321-321-4321");
        updateTest.setEstablished(LocalDate.of(2022, Month.SEPTEMBER, 1));
        tx.commit();

        // Find newly updated row
        Library compareTest = em.find(Library.class, updateTest.getId());

        // Check if updated successfully
        assertEquals("libraryUpdate", compareTest.getStreetAdd());
        assertEquals("321-321-4321", compareTest.getPhoneNum());
        assertEquals(LocalDate.of(2022, Month.SEPTEMBER, 1), compareTest.getEstablished());
    }

    @Test
    public void deleteTest() {
        Library deleteTest = new Library("deleteTest", "TestAddress", "123-123-1234", LocalDate.now());

        // Begin insertion sequence
        tx.begin();
        em.persist(deleteTest);
        tx.commit();

        // Make sure row was successfully inserted
        assertNotNull(deleteTest.getId());

        // Begin deletion sequence
        tx.begin();
        em.remove(deleteTest);
        tx.commit();

        // Attempt to read deleted object
        Library deleteCheck = em.find(Library.class, deleteTest.getId());

        assertNull(deleteCheck);
    }
}
