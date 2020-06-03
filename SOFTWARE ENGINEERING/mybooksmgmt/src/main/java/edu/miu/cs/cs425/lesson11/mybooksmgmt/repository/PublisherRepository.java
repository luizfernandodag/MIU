package edu.miu.cs.cs425.lesson11.mybooksmgmt.repository;

import edu.miu.cs.cs425.lesson11.mybooksmgmt.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
