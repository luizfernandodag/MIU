package edu.miu.cs.cs425.bookmgmt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs425.bookmgmt.model.Book;


@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}
