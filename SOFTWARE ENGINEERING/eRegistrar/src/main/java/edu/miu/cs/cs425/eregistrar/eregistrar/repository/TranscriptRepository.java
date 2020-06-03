package edu.miu.cs.cs425.eregistrar.eregistrar.repository;

import edu.miu.cs.cs425.eregistrar.eregistrar.model.Transcript;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TranscriptRepository extends CrudRepository<Transcript, Integer> {

}
