package edu.iit.sat.itmd4515.jreginaldo.service;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
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
    }
}
