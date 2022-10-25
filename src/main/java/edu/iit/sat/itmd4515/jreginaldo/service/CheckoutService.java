package edu.iit.sat.itmd4515.jreginaldo.service;

import edu.iit.sat.itmd4515.jreginaldo.domain.Author;
import edu.iit.sat.itmd4515.jreginaldo.domain.Checkout;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CheckoutService extends AbstractService<Checkout> {

    public CheckoutService() {
        super(Checkout.class);
    }

    @Override
    public List<Checkout> findAll() {
        return em.createNamedQuery("Checkout.findAll", Checkout.class).getResultList();
    }
}
