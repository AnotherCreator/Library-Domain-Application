package edu.iit.sat.itmd4515.jreginaldo.web;

import edu.iit.sat.itmd4515.jreginaldo.domain.Member;
import edu.iit.sat.itmd4515.jreginaldo.service.MemberService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
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

    /*
        PAGE DISPLAYS
    */
    public String saveMember() {
        LOG.info("Inside saveMember with " + this.member.toString());

        memberService.create(member);

        return "/data/newMember/memberConfirmation.xhtml";
    }

    public String memberReadPage(Member member) {
        LOG.info("Inside memberReadPage with " + member.toString());

        this.member = member;

        return "/data/readMember.xhtml";
    }

    public String memberUpdatePage(Member member) {
        LOG.info("Inside memberUpdatePage with " + member.toString());

        this.member = member;

        return "/data/updateMember.xhtml";
    }

    public String memberDeletePage(Member member) {
        LOG.info("Inside memberDeletePage with " + member.toString());

        this.member = member;

        return "/data/deleteMember.xhtml";
    }

    public String executeMemberReturnHome() {
        LOG.info("Inside executeMemberReturnHome");

        return "/welcome.xhtml?faces-redirect=true";
    }

    public String executeMemberUpdate() {
        LOG.info("Inside executeMemberUpdate with " + this.member.toString());

        memberService.updateMember(this.member);

        return "/welcome.xhtml?faces-redirect=true";
    }

    public String executeMemberDelete() {
        LOG.info("Inside executeMemberDelete with " + this.member.toString());

        memberService.deleteMember(this.member);

        return "/welcome.xhtml?faces-redirect=true";
    }

    /*
        GETTERS SETTERS
    */
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
