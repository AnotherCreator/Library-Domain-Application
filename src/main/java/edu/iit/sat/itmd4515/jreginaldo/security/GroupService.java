package edu.iit.sat.itmd4515.jreginaldo.security;

import edu.iit.sat.itmd4515.jreginaldo.service.AbstractService;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class GroupService extends AbstractService<Group> {

    public GroupService() {
        super(Group.class);
    }

    @Override
    public List<Group> findAll() {
        return em.createNamedQuery("Group.findAll", Group.class).getResultList();
    }
}
