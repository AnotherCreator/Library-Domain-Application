package edu.iit.sat.itmd4515.jreginaldo.service;

import edu.iit.sat.itmd4515.jreginaldo.domain.Author;
import edu.iit.sat.itmd4515.jreginaldo.domain.Employee;
import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.List;

@Named
@Stateless
public class EmployeeService extends AbstractService<Employee> {

    public EmployeeService() {
        super(Employee.class);
    }

    @Override
    public List<Employee> findAll() {
        return em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }
}
