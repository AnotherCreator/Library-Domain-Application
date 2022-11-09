package edu.iit.sat.itmd4515.jreginaldo.domain;

import edu.iit.sat.itmd4515.jreginaldo.security.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.logging.Logger;

public class AbstractSecurityJPATest {
    protected static EntityManagerFactory emf;
    protected static final Logger LOG = Logger.getLogger(LibraryJPATest.class.getName());
    protected EntityManager em;
    protected EntityTransaction tx;

    @BeforeAll
    public static void beforeAll() {
        emf = Persistence.createEntityManagerFactory("itmd4515testPU");
    }

    @BeforeEach
    public void beforeEach() {
        em = emf.createEntityManager();
        tx = em.getTransaction();

        User createUserTest = new User();
        createUserTest.setUserName("User Name");
        createUserTest.setPassword("Password");

        // Begin insertion sequence
        tx.begin();
        em.persist(createUserTest);
        tx.commit();
    }

    @AfterEach
    public void afterEach() {
        User deleteUserTest = em.createQuery(
                "SELECT u FROM User u WHERE u.userName = 'User Name'", User.class).getSingleResult();

        // Begin deletion sequence
        tx.begin();
        em.remove(deleteUserTest);
        tx.commit();
        em.close();
    }

    @AfterAll
    public static void afterAll() {
        emf.close();
    }
}
