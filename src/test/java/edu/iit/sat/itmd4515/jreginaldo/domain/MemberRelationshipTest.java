package edu.iit.sat.itmd4515.jreginaldo.domain;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.Month;


public class MemberRelationshipTest extends AbstractJPATest{
    @Test
    public void manyToManyBiDirectionalMemberToCheckoutRelationTest() {
        /*
            A singular member can have many checkouts at once
            1:N relationship (Bi-directional)
            Member(Owned) <--> Checkout(Owner)
        */
        Member member = new Member("Ocean", "Man", "111-111-1111", "111 Ocean Drive",
                0, 0);

        /*
            Multiple checkouts can belong to a singular member
            N:1 relationship (Bi-directional)
            Member(Owned) <--> Checkout(Owner)
        */
        // Change according to system clock
        // Reservation date --> Checkout date --> Return date
        Checkout checkout1 = new Checkout(LocalDate.of(2022, Month.JANUARY, 1), // Past or present
                LocalDate.of(2022, Month.NOVEMBER, 1),  // Future or present
                LocalDate.of(2022, Month.DECEMBER, 2)); // Future
        Checkout checkout2 = new Checkout(LocalDate.of(2022, Month.JANUARY, 2), // Past or present
                LocalDate.of(2022, Month.NOVEMBER, 1),  // Future or present
                LocalDate.of(2022, Month.DECEMBER, 2)); // Future

        // Add checkout info to member
        member.getCheckoutSet().add(checkout1);
        member.getCheckoutSet().add(checkout2);

        checkout1.setMember(member);
        checkout2.setMember(member);

        // Begin insertion sequence
        tx.begin();
        // Add entities to be added
        em.persist(member);
        em.persist(checkout1);
        em.persist(checkout2);
        // End
        tx.commit();

        // Assertions
        assertEquals(2, member.getCheckoutSet().size()); // Member should have two checkouts registered
        assertEquals(checkout1.getMember(), member);
        assertEquals(checkout2.getMember(), member); // Checkouts should be registered under the same member
    }

    @Test
    public void oneToOneUniDirectionalMemberToEmployeeRelationTest() {

    }
}
