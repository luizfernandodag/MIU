package edu.miu.cs.cs425.eregistrar.eregistrar.service.impl;

import edu.miu.cs.cs425.eregistrar.eregistrar.model.Student;
import edu.miu.cs.cs425.eregistrar.eregistrar.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Iterable<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }
}
