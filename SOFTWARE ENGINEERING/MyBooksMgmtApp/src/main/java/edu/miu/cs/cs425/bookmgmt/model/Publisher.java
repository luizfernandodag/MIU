package edu.miu.cs.cs425.bookmgmt.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity//Anotatation to indicate that this have to be mapped to a database
@Table(name = "publishers")
public class Publisher {
    @Id//specifies the primary key on the database
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer publisherId;
    //PUBLISHER is the owner of the relationship
    @OneToMany(mappedBy = "publishedBy",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<Book> booksPublished;


    @NotBlank(message = "Name is required")
    String name;

    public Publisher() {
        super();
    }

    @Override
    public String toString() {
        return "Publisher [publisherId=" + publisherId + ", name=" + name + "]";
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Publisher(Integer publisherId, List<Book> booksPublished,
                     @NotBlank(message = "Name is required") String name) {
        super();
        this.publisherId = publisherId;
        this.booksPublished = booksPublished;
        this.name = name;
    }

    public Publisher(List<Book> booksPublished, @NotBlank(message = "Name is required") String name) {
        super();
        this.booksPublished = booksPublished;
        this.name = name;
    }

    public List<Book> getBooksPublished() {
        return booksPublished;
    }

    public void setBooksPublished(List<Book> booksPublished) {
        this.booksPublished = booksPublished;
    }

    public void addBook(Book b) {
        if (b != null)
            this.getBooksPublished().add(b);
    }


}
