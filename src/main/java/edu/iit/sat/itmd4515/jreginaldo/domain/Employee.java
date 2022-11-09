package edu.iit.sat.itmd4515.jreginaldo.domain;

import edu.iit.sat.itmd4515.jreginaldo.security.User;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Objects;

// Entity will be uni-directional with 'Member'
// 'Employee' will be able to get 'Member' data
// 'Member' will not be able to see 'Employee' data

@Entity
@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
public class Employee {

    /*
            ========== CONSTRUCTORS ==========
     */
    public Employee() {

    }

    public Employee(String position, String department, LocalDate started, LocalDate ended) {
        this.position = position;
        this.department = department;
        this.started = started;
        this.ended = ended;
    }

    /*
        ========== OBJECT RELATED VARIABLES ==========
     */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @NotBlank
    @Size(min = 2, max = 255)
    @Column(name = "position")
    private String position;

    @NotBlank
    @Size(min = 2, max = 255)
    @Column(name = "department")
    private String department;

    @FutureOrPresent // Employee can start same day or have a future start date
    @Column(name = "started")
    private LocalDate started; // Date employee started working

    @FutureOrPresent
    @Column(name = "ended")
    private LocalDate ended; // Date employee stopped working

    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    /*
        ========== GETTER / SETTER ==========
     */
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /*
                        ========== @OVERRIDES ==========
         */
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

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", started=" + started +
                ", ended=" + ended +
                '}';
    }
}
