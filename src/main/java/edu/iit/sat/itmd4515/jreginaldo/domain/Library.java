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
public class Library {

    public Library() {

    }

    public Library(String name, String streetAdd, String phoneNum, LocalDate established) {
        this.name = name;
        this.streetAdd = streetAdd;
        this.phoneNum = phoneNum;
        this.established = established;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String streetAdd;

    @NotBlank
    private String phoneNum;

    @PastOrPresent @NotNull
    private LocalDate established;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAdd() {
        return streetAdd;
    }

    public void setStreetAdd(String streetAdd) {
        this.streetAdd = streetAdd;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public LocalDate getEstablished() {
        return established;
    }

    public void setEstablished(LocalDate established) {
        this.established = established;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", streetAdd='" + streetAdd + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", established=" + established +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        if ((this.id == null || library.id == null)) {
            return false;
        }
        return id.equals(library.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
