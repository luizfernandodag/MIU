package edu.cs.cs425.eregistrarwebapi.eregistrarwebapi.repository;

import edu.cs.cs425.eregistrarwebapi.eregistrarwebapi.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {



    List<Student> findAllByStudentNumberContainingOrFirstNameContainingOrLastNameContainingOrMiddleNameContainingOrIsInternationalContainsOrderByFirstName(
           String studentNumber,
           String firstName,
           String lastName,
           String isInternational,
           String middleName
    );

    // More queries
    List<Student> findStudentsByDateOfEnrollmentIsStartingWith(LocalDate str);
    List<Student> findStudentsByCpgaGreaterThanEqual(double str);


}
