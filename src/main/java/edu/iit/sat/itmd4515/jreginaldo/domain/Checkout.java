package edu.iit.sat.itmd4515.jreginaldo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Checkout {

    public Checkout() {

    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    // A member can place a now or be in a wait-list
    @PastOrPresent
    private LocalDate reservationDate;

    // A member can check out a book now or pick it up later / reach their wait list position
    @FutureOrPresent
    private LocalDate checkOutDate;

    // The return date will always be in the future
    @Future
    private LocalDate returnDate;

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
}
