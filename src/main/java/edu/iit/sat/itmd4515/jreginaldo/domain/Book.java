package edu.iit.sat.itmd4515.jreginaldo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Book {

    public Book() {

    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long barcode;

    @NotBlank
    @Size(min = 13, max = 13)
    @Column(name = "isbn")
    private String ISBN;

    @NotBlank
    @Size(min = 2, max = 255)
    @Column(name = "title")
    private String title;

    @NotBlank
    @Size(min = 2, max = 255)
    @Column(name = "author")
    private String author;

    @NotBlank
    @Size(min = 2, max = 255)
    @Column(name = "published_by")
    private String publishedBy;

    @NotBlank
    @Size(min = 2, max = 255)
    @Column(name = "genre")
    private String genre;

    @PastOrPresent
    private LocalDate publishedDate;

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishedBy() {
        return publishedBy;
    }

    public void setPublishedBy(String publishedBy) {
        this.publishedBy = publishedBy;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        if ((this.barcode == null || book.barcode == null)) {
            return false;
        }
        return barcode.equals(book.barcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barcode);
    }
}
