package edu.cs.cs425.eregistrarwebapi.eregistrarwebapi.impl;

import edu.cs.cs425.eregistrarwebapi.eregistrarwebapi.model.*;
import java.util.List;


public interface StudentService {
    public abstract List<Student> getAllStudents();
    public abstract Student saveStudent(Student student);
    public abstract Student getStudentById(Integer studentId);
    public abstract void deleteStudentById(Integer studentId);
    public abstract List<Student> searchStudents(String searchString);
    public abstract Student registerNewStudent(Student student);
    public abstract Student updateStudent(Student editedStudent, Integer studentId);

}
