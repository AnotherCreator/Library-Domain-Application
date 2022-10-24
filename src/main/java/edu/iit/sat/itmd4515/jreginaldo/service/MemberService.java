package edu.iit.sat.itmd4515.jreginaldo.service;

import edu.iit.sat.itmd4515.jreginaldo.domain.Member;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class MemberService extends AbstractService<Member> {

    public MemberService(Class<Member> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
