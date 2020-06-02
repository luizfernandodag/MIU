package edu.miu.cs.cs425.lesson11.mybooksmgmt.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer publisherId;

    @NotBlank(message = "Name is required")
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "publishedBy", cascade = CascadeType.PERSIST)
    private List<Book> booksPublished;

    public Publisher(Integer publisherId, String name, List<Book> booksPublished) {
        super();
        this.publisherId = publisherId;
        this.name = name;
        this.booksPublished = booksPublished;
    }

    public Publisher() {
        super();
    }

    public Publisher(String name, List<Book> booksPublished) {
        super();
        this.name = name;
        this.booksPublished = booksPublished;
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

    public List<Book> getBooksPublished() {
        return booksPublished;
    }

    public void setBooksPublished(List<Book> booksPublished) {
        this.booksPublished = booksPublished;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("Publisher [publisherId=%s, name=%s]", publisherId, name);
    }

}
