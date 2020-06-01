package edu.miu.cs.cs425.bookmgmt.model;

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

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name = "books")
public class Book {
	
	
	
	
	
	public Book(@NotBlank(message = "Title is required") String title,
			@NotBlank(message = "ISBN is required") String isbn, LocalDate datePublished) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.datePublished = datePublished;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long bookId;
	@NotBlank(message = "Title is required")
	private String title;
	//not null and not empty string
	@NotBlank(message="ISBN is required")
	@Column(name="isbn",unique=true,nullable=false)
	private String isbn;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate datePublished;
	
	
	//@ManyToOne(cascade = CascadeType.PERSIST)
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="published_by", referencedColumnName="publisherId",nullable=true)//FK collumn
	private Publisher publishedBy;
	
	public Book() {
		super();
	}

	
	
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public LocalDate getDatePublished() {
		return datePublished;
	}
	public void setDatePublished(LocalDate datePublished) {
		this.datePublished = datePublished;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", isbn=" + isbn + ", datePublished=" + datePublished
				+ ", publisherBy=" + publishedBy + "]";
	}

	public Publisher getPublisherBy() {
		return publishedBy;
	}

	public void setPublisherBy(Publisher publisherBy) {
		this.publishedBy = publisherBy;
	}

	public Book(@NotBlank(message = "Title is required") String title,
			@NotBlank(message = "ISBN is required") String isbn, LocalDate datePublished, Publisher publisherBy) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.datePublished = datePublished;
		this.publishedBy = publisherBy;
	}

	public Book(Long bookId, @NotBlank(message = "Title is required") String title,
			@NotBlank(message = "ISBN is required") String isbn, LocalDate datePublished, Publisher publisherBy) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.isbn = isbn;
		this.datePublished = datePublished;
		this.publishedBy = publisherBy;
	}
	
	
	

}
