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
        LOG.info("Inside MemberService.updateMember with " + em.createQuery(
                        "SELECT m FROM Member m WHERE m.firstName LIKE :memberFirstName " +
                                "AND m.lastName LIKE :memberLastName", Member.class)
                .setParameter("memberFirstName", member.getFirstName())
                .setParameter("memberLastName", member.getLastName())
                .getSingleResult());

        Member memberReference = em.createQuery(
                        "SELECT m FROM Member m WHERE m.firstName LIKE :memberFirstName " +
                                "AND m.lastName LIKE :memberLastName", Member.class)
                .setParameter("memberFirstName", member.getFirstName())
                .setParameter("memberLastName", member.getLastName())
                .getSingleResult();

        memberReference.setAddress(member.getAddress());
        memberReference.setPhone(member.getPhone());
        memberReference.setIsExpired(member.getIsExpired());
        memberReference.setMemberType(member.getMemberType());

        em.merge(memberReference);
    }

    public void deleteMember(Member member) {
        LOG.info("Inside MemberService.deleteMember with " + em.createQuery(
                        "SELECT m FROM Member m WHERE m.firstName LIKE :memberFirstName " +
                                "AND m.lastName LIKE :memberLastName", Member.class)
                .setParameter("memberFirstName", member.getFirstName())
                .setParameter("memberLastName", member.getLastName())
                .getSingleResult());

        Member memberReference = em.createQuery(
                        "SELECT m FROM Member m WHERE m.firstName LIKE :memberFirstName " +
                                "AND m.lastName LIKE :memberLastName", Member.class)
                .setParameter("memberFirstName", member.getFirstName())
                .setParameter("memberLastName", member.getLastName())
                .getSingleResult();

        em.remove(memberReference);
    }
}
