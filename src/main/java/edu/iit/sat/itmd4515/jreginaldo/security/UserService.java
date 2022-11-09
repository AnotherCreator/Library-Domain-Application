package edu.iit.sat.itmd4515.jreginaldo.security;

import edu.iit.sat.itmd4515.jreginaldo.service.AbstractService;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UserService extends AbstractService<User> {

    public UserService() {
        super(User.class);
    }

    @Override
    public List<User> findAll() {
        return em.createNamedQuery("User.findAll", User.class).getResultList();
    }
}
