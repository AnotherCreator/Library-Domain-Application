package edu.iit.sat.itmd4515.jreginaldo.domain;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Checkout {

    public Checkout() {

    }

    public Checkout(LocalDate reservationDate, LocalDate checkOutDate, LocalDate returnDate) {
        this.reservationDate = reservationDate;
        this.checkOutDate = checkOutDate;
        this.returnDate = returnDate;
    }

    /*
            ========== RELATIONSHIPS ==========
     */
    /*
        A checkout can have many books for order
        N:M Relationship bi-directional
        Checkout (Owner) <--> Book (Owned)
     */
    @ManyToMany
    @JoinTable(
            name = "books_for_checkout",
            joinColumns = @JoinColumn(name = "checkout_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> booksForCheckOut = new ArrayList<>();

    /*
        Multiple checkouts can belong to a singular member
        N:1 relationship (Bi-directional)
        Member(Owned) <--> Checkout(Owner)
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Member member;

    /*
        ========== OBJECT RELATED VARIABLES ==========
     */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    // A member can place a now or be in a wait-list
    @PastOrPresent
    @Column(name = "reservation_date")
    private LocalDate reservationDate;

    // A member can check out a book now or pick it up later / reach their wait list position
    @FutureOrPresent
    @Column(name = "checkout_date")
    private LocalDate checkOutDate;

    // The return date will always be in the future
    @Future
    @Column(name = "return_date")
    private LocalDate returnDate;

    /*
            ========== GETTER / SETTER ==========
     */
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public List<Book> getBooksForCheckOut() {
        return booksForCheckOut;
    }

    public void setBooksForCheckOut(List<Book> booksForCheckOut) {
        this.booksForCheckOut = booksForCheckOut;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    /*
                ========== @OVERRIDES ==========
         */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Checkout checkout = (Checkout) o;
        if ((this.ID == null || checkout.ID == null)) {
            return false;
        }
        return ID.equals(checkout.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "Checkout{" +
                "booksForCheckOut=" + booksForCheckOut +
                ", ID=" + ID +
                ", reservationDate=" + reservationDate +
                ", checkOutDate=" + checkOutDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
