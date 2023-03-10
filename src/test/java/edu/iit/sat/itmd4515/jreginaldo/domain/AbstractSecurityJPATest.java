package edu.iit.sat.itmd4515.jreginaldo.domain;

import edu.iit.sat.itmd4515.jreginaldo.security.Group;
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

        Group createGroupTest = new Group();
        createGroupTest.setGroupName("Group Name");
        createGroupTest.setGroupDesc("Group Desc");

        Group createGroupTest2 = new Group();
        createGroupTest2.setGroupName("Group Name 2");
        createGroupTest2.setGroupDesc("Group Desc");

        // Begin insertion sequence
        tx.begin();
        em.persist(createUserTest);
        em.persist(createGroupTest);
        em.persist(createGroupTest2);
        tx.commit();

    }

    @AfterEach
    public void afterEach() {
        User deleteUserTest = em.createQuery(
                "SELECT u FROM User u WHERE u.userName = 'User Name'", User.class).getSingleResult();
        Group deleteGroupTest = em.createQuery(
                "SELECT g FROM Group g WHERE g.groupName = 'Group Name'", Group.class).getSingleResult();
        Group deleteGroupTest2 = em.createQuery(
                "SELECT g FROM Group g WHERE g.groupName = 'Group Name 2'", Group.class).getSingleResult();

        // Begin deletion sequence
        tx.begin();
        em.remove(deleteUserTest);
        em.remove(deleteGroupTest);
        em.remove(deleteGroupTest2);
        tx.commit();
        em.close();
    }

    @AfterAll
    public static void afterAll() {
        emf.close();
    }
}
