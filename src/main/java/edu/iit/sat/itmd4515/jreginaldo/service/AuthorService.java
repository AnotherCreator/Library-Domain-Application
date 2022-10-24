package edu.iit.sat.itmd4515.jreginaldo.service;

import edu.iit.sat.itmd4515.jreginaldo.domain.Author;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class AuthorService extends AbstractService<Author> {

    public AuthorService(Class<Author> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Author> findAll() {
        return null;
    }
}
