package edu.iit.sat.itmd4515.jreginaldo.service;

import edu.iit.sat.itmd4515.jreginaldo.domain.Book;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class BookService extends AbstractService<Book> {

    public BookService(Class<Book> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Book> findAll() {
        return null;
    }
}
