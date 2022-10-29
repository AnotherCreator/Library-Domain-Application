package edu.iit.sat.itmd4515.jreginaldo.service;

import edu.iit.sat.itmd4515.jreginaldo.domain.Member;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class MemberService extends AbstractService<Member> {

    public MemberService() {
        super(Member.class);
    }

    @Override
    public List<Member> findAll() {
        return em.createNamedQuery("Member.findAll", Member.class).getResultList();
    }
}
