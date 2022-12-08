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

        return "/create/newMember/memberConfirmation.xhtml";
    }

    public String memberReadPage(Member member) {
        LOG.info("Inside memberReadPage with " + member.toString());

        this.member = member;

        LOG.info("Leaving memberReadPage with " + this.member);

        return "/admin/readMember.xhtml";
    }

    public String memberUpdatePage(Member member) {
        LOG.info("Inside memberUpdatePage with " + member.toString());

        this.member = member;

        LOG.info("Leaving memberUpdatePage with " + this.member);

        return "/admin/updateMember.xhtml";
    }

    public String memberDeletePage(Member member) {
        LOG.info("Inside memberDeletePage with " + member.toString());

        this.member = member;

        LOG.info("Leaving memberDeletePage with " + this.member);

        return "/admin/deleteMember.xhtml";
    }

    public String executeMemberUpdate() {
        LOG.info("Inside executeMemberUpdate with " + this.member.toString());

        memberService.updateMember(this.member);

        return "/admin/welcome.xhtml?faces-redirect=true";
    }

    public String executeMemberDelete() {
        LOG.info("Inside executeMemberDelete with " + this.member.toString());

        memberService.deleteMember(member);

        return "/admin/welcome.xhtml?faces-redirect=true";
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
