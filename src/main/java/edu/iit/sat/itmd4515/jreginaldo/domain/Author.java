package edu.iit.sat.itmd4515.jreginaldo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Author {

    /*
            ========== CONSTRUCTORS ==========
     */
    public Author() {

    }

    public Author(String firstName, String lastName, LocalDate DOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
    }

    /*
            ========== RELATIONSHIPS ==========
     */
    /*
        A singular author can write many books
        1:N Relationship (Bi-directional)
        Book(Owner) <--> Author(Owned)
     */
    @OneToMany(mappedBy = "author")
    private List<Book> bookSet = new ArrayList<>();

    /*
        ========== OBJECT RELATED VARIABLES ==========
     */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @NotBlank
    @Size(min = 2, max = 255)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 255)
    @Column(name = "last_name")
    private String lastName;

    @PastOrPresent
    @Column(name = "date_of_birth")
    private LocalDate DOB; // Date of Birth

    /*
        ========== GETTER / SETTER ==========
     */
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public List<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(List<Book> bookSet) {
        this.bookSet = bookSet;
    }

    /*
            ========== @OVERRIDES ==========
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        if ((this.ID == null || author.ID == null)) {
            return false;
        }
        return ID.equals(author.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "Author{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DOB=" + DOB +
                '}';
    }
}
