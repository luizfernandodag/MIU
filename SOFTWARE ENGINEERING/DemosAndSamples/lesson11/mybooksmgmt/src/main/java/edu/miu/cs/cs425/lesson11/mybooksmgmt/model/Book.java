package edu.miu.cs.cs425.lesson11.mybooksmgmt.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @NotBlank(message = "ISBN is required")
    @Column(name = "isbn", unique = true, nullable = false)
    private String isbn;

    @NotEmpty
    @NotNull
    @NotBlank(message = "Title is required") // -- null, "", " "
//	@Column(nullable=false)
    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePublished;

    @ManyToOne
    @JoinColumn(name = "published_by", nullable = false)
    private Publisher publishedBy;

    public Book(Long bookId, String isbn, String title, LocalDate datePublished, Publisher publishedBy) {
        super();
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.datePublished = datePublished;
        this.publishedBy = publishedBy;
    }

    public Book(@NotBlank(message = "ISBN is required") String isbn,
                @NotBlank(message = "Title is required") String title, LocalDate datePublished, Publisher publishedBy) {
        super();
        this.isbn = isbn;
        this.title = title;
        this.datePublished = datePublished;
        this.publishedBy = publishedBy;
    }

    public Book() {
        super();
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(LocalDate datePublished) {
        this.datePublished = datePublished;
    }

    public Publisher getPublishedBy() {
        return publishedBy;
    }

    public void setPublishedBy(Publisher publishedBy) {
        this.publishedBy = publishedBy;
    }

    @Override
    public String toString() {
        return String.format("Book [bookId=%s, isbn=%s, title=%s, datePublished=%s, publsher=%s]", bookId, isbn, title,
                datePublished, publishedBy);
    }

}
