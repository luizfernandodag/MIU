package edu.cs.cs425.eregistrarwebapi.eregistrarwebapi.impl;

import edu.cs.cs425.eregistrarwebapi.eregistrarwebapi.model.*;
import edu.cs.cs425.eregistrarwebapi.eregistrarwebapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository repository;



    @Override
    public List<Student> getAllStudents() {
        return (List<Student>)repository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);

    }

    @Override
    public Student getStudentById(Integer studentId) {
        return repository.findById(studentId).orElse(null);
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        repository.deleteById(studentId);

    }

    @Override
    public List<Student> searchStudents(String searchString) {
        if(containsDecimalPoint(searchString) && isGPA(searchString)) {
            return repository.findStudentsByCpgaGreaterThanEqual(Double.parseDouble(searchString));

        } else if(isDate(searchString)) {
            return repository.findStudentsByDateOfEnrollmentIsStartingWith(LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE));
        } else {
            return repository.findAllByStudentNumberContainingOrFirstNameContainingOrLastNameContainingOrMiddleNameContainingOrIsInternationalContainsOrderByFirstName(searchString, searchString, searchString, searchString, searchString);
        }
    }

    @Override
    public Student registerNewStudent(Student student) {
       return  this.repository.save(student);
    }

    @Override
    public Student updateStudent(Student editedStudent, Integer studentId) {
        return this.repository.findById(studentId).map(
                student -> {
                    student.setCpga(editedStudent.getCpga());
                    student.setDateOfEnrollment(editedStudent.getDateOfEnrollment());
                    student.setFirstName(editedStudent.getFirstName());
                    student.setMiddleName(editedStudent.getMiddleName());
                    student.setLastName(editedStudent.getLastName());
                    student.setIsInternational(editedStudent.getIsInternational());
                    student.setStudentNumber(editedStudent.getStudentNumber());
                    return this.repository.save(student);
                }
        ).orElseGet(
                ()->{return this.repository.save(editedStudent);}
                    );
    }


    private boolean isGPA(String searchString) {
        boolean isParseableAsGPA = false;
        try {
            Double.parseDouble(searchString);
            isParseableAsGPA = true;
        } catch(Exception ex) {
            if(ex instanceof ParseException) {
                isParseableAsGPA = false;
            }
        }
        return isParseableAsGPA;
    }

    private boolean isDate(String searchString) {
        boolean isParseableAsDate = false;
        try {
            LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE);
            isParseableAsDate = true;
        } catch(Exception ex) {
            if(ex instanceof DateTimeParseException) {
                isParseableAsDate = false;
            }
        }
        return isParseableAsDate;
    }

    private boolean containsDecimalPoint(String searchString) {
        return searchString.contains(".");
    }
}


        
