package edu.iit.sat.itmd4515.jreginaldo.service;

import edu.iit.sat.itmd4515.jreginaldo.domain.Member;
import edu.iit.sat.itmd4515.jreginaldo.web.MemberController;

import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.List;
import java.util.logging.Logger;

@Named
@Stateless
public class MemberService extends AbstractService<Member> {
    private static final Logger LOG = Logger.getLogger(MemberController.class.getName());

    public MemberService() {
        super(Member.class);
    }

    @Override
    public List<Member> findAll() {
        return em.createNamedQuery("Member.findAll", Member.class).getResultList();
    }

    public Member findByUsername(String username) {
        return em.createNamedQuery("Member.findByUsername", Member.class)
                .setParameter("username", username).getSingleResult();
    }

    public void updateMember(Member member) {
//        Member memberReference = em.getReference(Member.class, member.getID());
//
//        memberReference.setIsExpired(member.getIsExpired());
//
//        em.merge(memberReference);
    }

    public void deleteMember(Member member) {
        Member memberReference = em.getReference(Member.class, member.getID());

        em.remove(memberReference);
    }
}
