package edu.iit.sat.itmd4515.jreginaldo.service;

import edu.iit.sat.itmd4515.jreginaldo.domain.Author;
import edu.iit.sat.itmd4515.jreginaldo.domain.Book;
import edu.iit.sat.itmd4515.jreginaldo.domain.Checkout;
import edu.iit.sat.itmd4515.jreginaldo.domain.Member;

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

    public StartupSampleDataService() {

    }

    @PostConstruct
    private void postConstruct() {
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

        for (Member member : memberService.findAll()) {
            LOG.info(" ========== MEMBER ========== \n" + member.toString());
        }

        for (Checkout checkout : checkoutService.findAll()) {
            LOG.info(" ========== CHECKOUT ========== \n" + checkout.toString());
            LOG.info(" ========== CHECKOUT MEMBER ========== \n" + checkout.getMember().toString());
        }
    }
}
