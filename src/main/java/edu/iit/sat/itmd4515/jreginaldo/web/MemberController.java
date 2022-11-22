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

    /*
        CRUD METHOD IMPLEMENTATION FOR WEB VIEW
    */
    public String memberReadPage(Member member) {
        LOG.info("Inside memberReadPage with " + member.toString());
        this.member = member;

        return "/admin/readMember.xhtml";
    }

    public String memberEditPage(Member member) {
        LOG.info("Inside memberEditPage with " + member.toString());
        this.member = member;

        return "/admin/editMember.xhtml";
    }

    public String memberDeletePage(Member member) {
        LOG.info("Inside memberEditPage with " + member.toString());
        this.member = member;

        return "/admin/deleteMember.xhtml";
    }

    public String saveMember() {
        LOG.info("Inside saveMember with " + this.member.toString());

        memberService.create(member);

        return "/create/newMember/memberConfirmation.xhtml";
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
