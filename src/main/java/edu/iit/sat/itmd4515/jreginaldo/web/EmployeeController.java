package edu.iit.sat.itmd4515.jreginaldo.web;

import edu.iit.sat.itmd4515.jreginaldo.domain.Employee;
import edu.iit.sat.itmd4515.jreginaldo.service.EmployeeService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class EmployeeController {

    private static final Logger LOG = Logger.getLogger(MemberController.class.getName());

    @EJB
    private EmployeeService employeeService;
    private Employee employee;

    public EmployeeController() {

    }

    private void postConstruct(){
        LOG.info("Inside EmployeeController.postConstuct");

        employee = new Employee();
    }

    public String saveEmployee() {
        LOG.info("Inside saveEmployee with " + this.employee.toString());

        employeeService.create(employee);

        return "/data/manageEmployee/employeeConfirmation.xhtml";
    }

    public String executeEmployeeReturnHome() {
        LOG.info("Inside executeMemberReturnHome");

        return "/welcome.xhtml?faces-redirect=true";
    }

    /*
        GETTERS SETTERS
    */
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
