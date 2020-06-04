package edu.cs.cs425.eregistrarwebapi.eregistrarwebapi.repository;

import edu.cs.cs425.eregistrarwebapi.eregistrarwebapi.model.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TranscriptRepository extends CrudRepository<Transcript, Integer> {

}
