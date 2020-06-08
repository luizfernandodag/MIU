package edu.cs.cs425.eregistrarwebapi.eregistrarwebapi.controller;

import edu.cs.cs425.eregistrarwebapi.eregistrarwebapi.impl.StudentService;
import edu.cs.cs425.eregistrarwebapi.eregistrarwebapi.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import javax.validation.Valid;
import java.util.List;


@RestController
//@CrossOrigin(origins = "*",allowCredentials = "*")
//@CrossOrigin(allowCredentials = "*")
@RequestMapping(value = "/eregistrar/api/student", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class StudentRESTController {

    private StudentService studentService;
    @Autowired
    public StudentRESTController(StudentService studentService) {
        this.studentService = studentService;
    }

    @DeleteMapping(value = {"/delete/{studentId}"})
    public void deleteStudent(@PathVariable Integer studentId) {
        studentService.deleteStudentById(studentId);
    }

    @GetMapping(value = "/list")
    public List<Student> list() {
        return studentService.getAllStudents();
    }


    @PostMapping(value= "/register")
    public Student registerNewStudent(@Valid @RequestBody Student student)
    {
        return this.studentService.registerNewStudent(student);
    }
    @PutMapping(value = "/update/{studentId}")
    public Student updateStudent(@Valid @RequestBody  Student editedStudent,@PathVariable Integer studentId)
    {
            return this.studentService.updateStudent(editedStudent, studentId);
    }
}
