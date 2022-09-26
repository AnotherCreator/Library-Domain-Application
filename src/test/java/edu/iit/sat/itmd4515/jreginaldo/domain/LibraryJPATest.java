package edu.iit.sat.itmd4515.jreginaldo.domain;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
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

    }

    @Test
    public void updateTest() {

    }

    @Test
    public void deleteTest() {

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
