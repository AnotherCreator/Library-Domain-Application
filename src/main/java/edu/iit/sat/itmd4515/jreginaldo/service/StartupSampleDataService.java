package edu.iit.sat.itmd4515.jreginaldo.service;

import edu.iit.sat.itmd4515.jreginaldo.domain.*;
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

        // Non-Owning Entities First
        groupService.create(memberGroup);
        groupService.create(employeeGroup);
        groupService.create(adminGroup);

        // Create users
        User member = new User("member", "member");
        User member1 = new User("member1", "member1");

        userService.create(member);
        userService.create(member1);

        User employee = new User("employee", "employee");
        userService.create(employee);

        User admin = new User("admin", "admin");
        userService.create(admin);

        // Add users to groups
        member.addGroup(memberGroup); // Non-employee

        member1.addGroup(memberGroup); // Employee
        member1.addGroup(employeeGroup); // Employees are automatically members

        employee.addGroup(employeeGroup);

        admin.addGroup(adminGroup);

        LOG.info("Inside StartupSampleDataService.postConstruct method");

        // Non-employee user with single group
        Member m = new Member("Member Non Employee Fname", "Member Non Employee Lname", "111-111-1111", "111 Ocean Drive",
                0, 0);
        m.setUser(member); // Non-Employee
        memberService.create(m);

        // Employee user with both member + employee group
        Member m1 = new Member("Member1 Employee Fname", "Member1 Employee Lname", "111-111-1111", "111 Ocean Drive",
                2, 0);
        m1.setUser(member1);
        memberService.create(m1);

        Employee emp = new Employee("Position", "Department",
                LocalDate.now(), // Future or Present
                LocalDate.of(2024, Month.JANUARY, 1)); // Future
        emp.setUser(member1);
        employeeService.create(emp);

        // Entities that OWN relationships
        Checkout checkout1 = new Checkout(LocalDate.of(2022, Month.JANUARY, 1), // Past or present
                LocalDate.now(),  // Future or present
                LocalDate.of(2023, Month.DECEMBER, 2)); // Future
        Checkout checkout2 = new Checkout(LocalDate.of(2022, Month.JANUARY, 2), // Past or present
                LocalDate.now(),  // Future or present
                LocalDate.of(2023, Month.DECEMBER, 2)); // Future

        m.getCheckoutSet().add(checkout1);
        m.getCheckoutSet().add(checkout2);

        checkout1.setMember(m);
        checkout2.setMember(m);

        checkoutService.create(checkout1);
        checkoutService.create(checkout2);

        for (Member mem : memberService.findAll()) {
            LOG.info(" ========== MEMBER ========== \n" + mem.toString());
        }

        for (Checkout checkout : checkoutService.findAll()) {
            LOG.info(" ========== CHECKOUT ========== \n" + checkout.toString());
            LOG.info(" ========== CHECKOUT MEMBER ========== \n" + checkout.getMember().toString());
        }
    }
}
