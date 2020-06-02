package edu.miu.cs.cs425.bookmgmt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs425.bookmgmt.model.Book;
import edu.miu.cs.cs425.bookmgmt.model.Publisher;


@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Query("select b from Book b where b.publishedBy.publisherId = :publisherId")
    public abstract Iterable<Book> getBooksByPublisher(Integer publishedId);

    public abstract Iterable<Book> findBooksByPublishedByEquals(Publisher publisherBy);


}
