package edu.iit.sat.itmd4515.jreginaldo.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

abstract class AbstractService<T> {

    @PersistenceContext(name = "itmd4515PU")
    protected EntityManager em;

    public AbstractService() {

    }

    public void create(T entity) {

    }
}
