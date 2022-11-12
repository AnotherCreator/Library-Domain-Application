package edu.iit.sat.itmd4515.jreginaldo.web;

import edu.iit.sat.itmd4515.jreginaldo.security.User;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class LoginController {

    private static final Logger LOG = Logger.getLogger(MemberController.class.getName());

    private User user;

    public LoginController() {
    }

    @PostConstruct
    private void postConstruct() {
        LOG.info("Inside LoginController.postConstuct");

        user = new User();
    }

    public String doLogin() {
        LOG.info("Inside LoginController.doLogin");

        return "/member/welcome.xhtml";
    }
}
