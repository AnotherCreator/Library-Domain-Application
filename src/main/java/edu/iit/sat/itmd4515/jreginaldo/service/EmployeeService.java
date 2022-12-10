package edu.iit.sat.itmd4515.jreginaldo.service;

import edu.iit.sat.itmd4515.jreginaldo.domain.Employee;
import edu.iit.sat.itmd4515.jreginaldo.domain.Member;
import edu.iit.sat.itmd4515.jreginaldo.web.MemberController;

import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.List;
import java.util.logging.Logger;

@Named
@Stateless
public class EmployeeService extends AbstractService<Employee> {

    private static final Logger LOG = Logger.getLogger(MemberController.class.getName());

    public EmployeeService() {
        super(Employee.class);
    }

    @Override
    public List<Employee> findAll() {
        return em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }

    public Member findByID(Employee employee) {
        return em.find(Member.class, employee.getID());
    }

    public void updateEmployee(Employee employee) {
        Employee e = findByID(employee).getEmployee();

        LOG.info("Inside EmployeeService.updateEmployee with Employee.ID: " + e.getID());
    }

    public void deleteEmployee(Employee employee) {
        Employee e = findByID(employee).getEmployee();

        LOG.info("Inside EmployeeService.deleteEmployee with " + e.toString());

        em.remove(e);
    }
}