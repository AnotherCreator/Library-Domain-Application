package edu.iit.sat.itmd4515.jreginaldo.web;

import edu.iit.sat.itmd4515.jreginaldo.domain.Member;
import edu.iit.sat.itmd4515.jreginaldo.service.MemberService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class MemberController {

    private static final Logger LOG = Logger.getLogger(MemberController.class.getName());

    @EJB
    private MemberService memberService;
    private Member member;

    public MemberController() {
    }

    @PostConstruct
    private void postConstruct() {
        LOG.info("Inside MemberController.postConstuct");

        member = new Member();
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String saveMember() {
        LOG.info("Inside saveMember with " + this.member.toString());

        memberService.create(member);

        return "/create/newMember/memberConfirmation.xhtml";
    }

    // MEMBER CRUD METHODS FOR /admin/welcome.xhtml

}
