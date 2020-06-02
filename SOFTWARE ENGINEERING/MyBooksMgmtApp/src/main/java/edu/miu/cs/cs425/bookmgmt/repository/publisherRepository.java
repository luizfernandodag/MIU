package edu.miu.cs.cs425.bookmgmt.repository;

import org.springframework.data.repository.CrudRepository;

import edu.miu.cs.cs425.bookmgmt.model.Publisher;

public interface publisherRepository extends CrudRepository<Publisher, Long> {

}
