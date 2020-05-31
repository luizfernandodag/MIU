package edu.miu.cs.cs425.bookmgmt;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.miu.cs.cs425.bookmgmt.model.Book;
import edu.miu.cs.cs425.bookmgmt.model.Publisher;

import edu.miu.cs.cs425.bookmgmt.repository.BookRepository;

@SpringBootApplication
public class MyBooksMgmtAppApplication implements CommandLineRunner {
	
	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyBooksMgmtAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Book book = new Book("123-4567890","Principles of Software Engineering", LocalDate.of(1999, 1, 10));
		Publisher p1 = new Publisher(null,"Pearsons");
		Book book1 = new Book("123-4567890","Principles of Software Engineering", LocalDate.of(1999, 1, 10),p1);
		Book book2 = new Book("123-4567891","Introduction to  Engineering", LocalDate.of(1999, 2, 10),p1);
		List<Book> books = Arrays.asList(book1,book2);
		p1.setBooksPublished(books);

		Book savedBook = saveBook(book1);
		System.out.println(savedBook);
		
		Book savedBook2 = saveBook(book2);
		System.out.println(savedBook2);
		
	}
	@Transactional
	private Book saveBook(Book book)
	{
		return bookRepository.save(book);
	}

}
