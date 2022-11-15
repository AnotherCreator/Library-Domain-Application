package edu.iit.sat.itmd4515.jreginaldo.web;

import edu.iit.sat.itmd4515.jreginaldo.domain.Member;
import edu.iit.sat.itmd4515.jreginaldo.service.MemberService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;

// Structure as demo'd in class

@Named
@RequestScoped
public class MemberWelcomeController {

    private static final Logger LOG = Logger.getLogger(MemberWelcomeController.class.getName());

    @EJB
    MemberService memberService;
    private Member member;

    @Inject
    LoginController loginController;

    public MemberWelcomeController() {
    }

    @PostConstruct
    private void postConstruct() {
        LOG.info("Inside MemberWelcomeController.postConstruct");

        member = memberService.findByUsername(loginController.getAuthenticatedUser());
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
