package edu.iit.sat.itmd4515.jreginaldo.service;

import edu.iit.sat.itmd4515.jreginaldo.domain.Author;
import edu.iit.sat.itmd4515.jreginaldo.domain.Employee;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class EmployeeService extends AbstractService<Employee> {

    public EmployeeService(Class<Employee> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Employee> findAll() {
        return em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }
}
