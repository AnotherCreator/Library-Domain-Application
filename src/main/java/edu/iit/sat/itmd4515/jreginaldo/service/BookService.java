package edu.iit.sat.itmd4515.jreginaldo.service;

import edu.iit.sat.itmd4515.jreginaldo.domain.Author;
import edu.iit.sat.itmd4515.jreginaldo.domain.Book;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class BookService extends AbstractService<Book> {

    public BookService() {
        super(Book.class);
    }

    @Override
    public List<Book> findAll() {
        return em.createNamedQuery("Book.findAll", Book.class).getResultList();
    }
}
