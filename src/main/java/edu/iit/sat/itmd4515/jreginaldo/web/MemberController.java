package edu.iit.sat.itmd4515.jreginaldo.web;

import edu.iit.sat.itmd4515.jreginaldo.domain.Member;
import edu.iit.sat.itmd4515.jreginaldo.service.MemberService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class MemberController {

    private static final Logger LOG = Logger.getLogger(MemberController.class.getName());

    @EJB private MemberService memberService;
    private Member member;

    public MemberController() {

    }


}
