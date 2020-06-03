package edu.miu.cs.cs425.eregistrar.eregistrar.repository;

import edu.miu.cs.cs425.eregistrar.eregistrar.model.Student;
import edu.miu.cs.cs425.eregistrar.eregistrar.model.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
