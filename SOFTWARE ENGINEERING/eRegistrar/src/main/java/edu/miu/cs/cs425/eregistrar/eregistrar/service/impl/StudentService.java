package edu.miu.cs.cs425.eregistrar.eregistrar.service.impl;

import edu.miu.cs.cs425.eregistrar.eregistrar.model.Student;

import java.util.List;


public interface StudentService {
    public abstract List<Student> getAllStudents();
    public abstract Student saveStudent(Student student);
    public abstract Student getStudentById(Integer studentId);
    public abstract void deleteStudentById(Integer studentId);
    public abstract List<Student> searchStudents(String searchString);

}
