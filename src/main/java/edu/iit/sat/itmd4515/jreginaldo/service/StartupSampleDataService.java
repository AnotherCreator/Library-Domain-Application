package edu.iit.sat.itmd4515.jreginaldo.service;

import edu.iit.sat.itmd4515.jreginaldo.domain.Author;
import edu.iit.sat.itmd4515.jreginaldo.domain.Book;
import edu.iit.sat.itmd4515.jreginaldo.domain.Checkout;
import edu.iit.sat.itmd4515.jreginaldo.domain.Member;
import edu.iit.sat.itmd4515.jreginaldo.security.Group;
import edu.iit.sat.itmd4515.jreginaldo.security.GroupService;
import edu.iit.sat.itmd4515.jreginaldo.security.User;
import edu.iit.sat.itmd4515.jreginaldo.security.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Logger;

@Startup
@Singleton
public class StartupSampleDataService {

    private static final Logger LOG = Logger.getLogger(StartupSampleDataService.class.getName());

    @EJB private AuthorService authorService;
    @EJB private BookService bookService;
    @EJB private CheckoutService checkoutService;
    @EJB private EmployeeService employeeService;
    @EJB private MemberService memberService;
    @EJB private UserService userService;
    @EJB private GroupService groupService;

    public StartupSampleDataService() {

    }

    @PostConstruct
    private void postConstruct() {
        // Initialize security realm / identity store
        Group memberGroup = new Group("MEMBER_GROUP", "This group represents library members");
        Group employeeGroup = new Group("EMPLOYEE_GROUP", "This group represents library employees");
        Group adminGroup = new Group("ADMIN_GROUP", "This group represents library admins");

        // Create users
        User member = new User("member", "member");
        User member2 = new User("member2", "member2");
        User member3 = new User("member3", "member3");

        User employee = new User("employee", "employee");
        User employee2 = new User("employee2", "employee2");

        User admin = new User("admin", "admin");

        // Add users to groups
        member.addGroup(memberGroup); // Non-employee

        // Employees are automatically members
        member2.addGroup(memberGroup); // Employee
        member2.addGroup(employeeGroup);

        member3.addGroup(memberGroup); // Employee 2
        member3.addGroup(employeeGroup);

        // Employees are automatically members
        employee.addGroup(employeeGroup);
        employee.addGroup(memberGroup); // Member 2

        employee2.addGroup(employeeGroup);
        employee2.addGroup(memberGroup); // Member 3

        admin.addGroup(adminGroup);

        LOG.info("Inside StartupSampleDataService.postConstruct method");

        // Entities that DO NOT OWN relationships
        Member member1 = new Member("Ocean", "Man", "111-111-1111", "111 Ocean Drive",
                0, 0);

        memberService.create(member1);

        // Entities that OWN relationships
        Checkout checkout1 = new Checkout(LocalDate.of(2022, Month.JANUARY, 1), // Past or present
                LocalDate.of(2023, Month.NOVEMBER, 1),  // Future or present
                LocalDate.of(2023, Month.DECEMBER, 2)); // Future
        Checkout checkout2 = new Checkout(LocalDate.of(2022, Month.JANUARY, 2), // Past or present
                LocalDate.of(2023, Month.NOVEMBER, 1),  // Future or present
                LocalDate.of(2023, Month.DECEMBER, 2)); // Future

        member1.getCheckoutSet().add(checkout1);
        member1.getCheckoutSet().add(checkout2);

        checkout1.setMember(member1);
        checkout2.setMember(member1);

        checkoutService.create(checkout1);
        checkoutService.create(checkout2);

        for (Member m : memberService.findAll()) {
            LOG.info(" ========== MEMBER ========== \n" + m.toString());
        }

        for (Checkout checkout : checkoutService.findAll()) {
            LOG.info(" ========== CHECKOUT ========== \n" + checkout.toString());
            LOG.info(" ========== CHECKOUT MEMBER ========== \n" + checkout.getMember().toString());
        }
    }
}
