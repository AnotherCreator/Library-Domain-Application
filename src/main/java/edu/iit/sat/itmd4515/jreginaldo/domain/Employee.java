package edu.iit.sat.itmd4515.jreginaldo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Employee {

    public Employee() {

    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String position;
    private String department;
    private LocalDate started; // Date employee started working
    private LocalDate ended; // Date employee stopped working

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getStarted() {
        return started;
    }

    public void setStarted(LocalDate started) {
        this.started = started;
    }

    public LocalDate getEnded() {
        return ended;
    }

    public void setEnded(LocalDate ended) {
        this.ended = ended;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        if ((this.ID == null || employee.ID == null)) {
            return false;
        }
        return ID.equals(employee.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
