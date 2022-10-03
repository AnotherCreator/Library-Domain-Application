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
public class Book {

    /*
            ========== CONSTRUCTORS ==========
     */
    public Book() {

    }

    public Book(Author author, Long barcode, String ISBN, String title, String authorName, String publishedBy,
                String genre, LocalDate publishedDate) {
        this.author = author;
        this.barcode = barcode;
        this.ISBN = ISBN;
        this.title = title;
        this.authorName = authorName;
        this.publishedBy = publishedBy;
        this.genre = genre;
        this.publishedDate = publishedDate;
    }

    /*
            ========== RELATIONSHIPS ==========
     */
    /*
        Many books can be written by the same author
        N:1 Relationship
        Book(Owner) <--> Author (Owned)
     */
    @ManyToOne
    private Author author;

    /*
        Many books can be reserved by many people
        N:M Relationship bi-directional
        Checkout (Owner) <--> Book (Owned)
     */
    @ManyToMany(mappedBy = "booksForCheckOut")
    private List<Checkout> checkoutSet = new ArrayList<>();

    /*
        ========== OBJECT RELATED VARIABLES ==========
     */
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
    @Column(name = "author_name")
    private String authorName;

    @NotBlank
    @Size(min = 2, max = 255)
    @Column(name = "published_by")
    private String publishedBy;

    @NotBlank
    @Size(min = 2, max = 255)
    @Column(name = "genre")
    private String genre;

    @PastOrPresent
    @Column(name = "published_date")
    private LocalDate publishedDate;

    /*
        ========== GETTER / SETTER ==========
     */
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String author) {
        this.authorName = author;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Checkout> getCheckoutSet() {
        return checkoutSet;
    }

    public void setCheckoutSet(List<Checkout> checkoutSet) {
        this.checkoutSet = checkoutSet;
    }

    /*
            ========== @OVERRIDES ==========
     */
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

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                ", barcode=" + barcode +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", publishedBy='" + publishedBy + '\'' +
                ", genre='" + genre + '\'' +
                ", publishedDate=" + publishedDate +
                '}';
    }
}
