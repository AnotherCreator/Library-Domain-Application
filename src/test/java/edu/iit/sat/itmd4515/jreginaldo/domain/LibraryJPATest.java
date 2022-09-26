package edu.iit.sat.itmd4515.jreginaldo.domain;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Logger;

public class LibraryJPATest {
    private static EntityManagerFactory emf;
    private static final Logger LOG = Logger.getLogger(LibraryJPATest.class.getName());
    private EntityManager em;
    private EntityTransaction tx;

    @BeforeAll
    public static void beforeAll() {
        emf = Persistence.createEntityManagerFactory("itmd4515testPU");
    }

    @BeforeEach
    public void beforeEach() {
        em = emf.createEntityManager();
        tx = em.getTransaction();

        Library libraryTest = new Library("libraryTest", "TestAddress", "123-123-1234", LocalDate.now());
        tx.begin();
        em.persist(libraryTest);
        tx.commit();
    }

    @Test
    public void createTest() {

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

    @AfterEach
    public void afterEach() {
        Library deleteTest = em.createQuery(
                "SELECT l FROM Library l WHERE l.name = 'libraryTest'", Library.class).getSingleResult();

        tx.begin();
        em.remove(deleteTest);
        tx.commit();
        em.close();
    }

    @AfterAll
    public static void afterAll() {
        emf.close();
    }
}
