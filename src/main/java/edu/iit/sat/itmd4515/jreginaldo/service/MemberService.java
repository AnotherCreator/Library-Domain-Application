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

    public Member findByID(Member member) {
        return em.find(Member.class, member.getID());
    }

    public void updateMember(Member member) {
        Member m = findByID(member);

        LOG.info("Inside MemberService.updateMember with Member.ID: " + m.getID());

        m.setID(member.getID());
        m.setFirstName(member.getFirstName());
        m.setLastName(member.getLastName());
        m.setAddress(member.getAddress());
        m.setPhone(member.getPhone());
        m.setIsExpired(member.getIsExpired());
        m.setMemberType(member.getMemberType());

        em.merge(m);

        LOG.info("Successfully updated member with " + m);
    }

    public void deleteMember(Member member) {
        Member m = findByID(member);

        LOG.info("Inside MemberService.deleteMember with " + findByID(member).toString());

        em.remove(m);
    }
}
