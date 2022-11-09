package edu.iit.sat.itmd4515.jreginaldo.domain;

import edu.iit.sat.itmd4515.jreginaldo.security.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecurityUserJPATest extends AbstractSecurityJPATest {
    @Test
    public void createTest() {
        User readFromAbstract = em.createQuery(
                "SELECT u FROM User u WHERE u.userName = 'User Name'", User.class).getSingleResult();

        // Find newly updated row
        User compareTest = em.find(User.class, readFromAbstract.getUserName());
        assertEquals(compareTest.getPassword(), readFromAbstract.getPassword());
    }

    @Test
    public void readTest() {
        User readFromAbstract = em.createQuery(
                "SELECT u FROM User u WHERE u.userName = 'User Name'", User.class).getSingleResult();
        assertEquals("User Name", readFromAbstract.getUserName());
    }

    @Test
    public void updateTest() {
        User readFromAbstract = em.createQuery(
                "SELECT u FROM User u WHERE u.userName = 'User Name'", User.class).getSingleResult();

        // Begin update sequence
        tx.begin();
        readFromAbstract.setPassword("Password2");
        tx.commit();

        // Find newly updated row
        User compareTest = em.find(User.class, readFromAbstract.getUserName());

        // Check if updated successfully
        assertEquals("Password2", compareTest.getPassword());
    }

    @Test
    public void deleteTest() {
        User createUserTest = new User();
        createUserTest.setUserName("User Name 2");
        createUserTest.setPassword("Password");

        // Begin insertion sequence
        tx.begin();
        em.persist(createUserTest);
        tx.commit();

        // Make sure row was successfully inserted
        assertNotNull(createUserTest.getUserName());

        // Begin deletion sequence
        tx.begin();
        em.remove(createUserTest);
        tx.commit();

        // Attempt to read deleted object
        User deleteCheck = em.find(User.class, createUserTest.getUserName());
        assertNull(deleteCheck);
    }
}
