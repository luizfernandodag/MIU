package edu.cs.cs425.eregistrarwebapi.eregistrarwebapi.controller;

import edu.cs.cs425.eregistrarwebapi.eregistrarwebapi.impl.StudentService;
import edu.cs.cs425.eregistrarwebapi.eregistrarwebapi.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
//@CrossOrigin(origins = "*",allowCredentials = "*")
//@CrossOrigin(allowCredentials = "*")
@RequestMapping(value = "/eregistrar/api/student", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*",allowedHeaders = "*")
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

    //@RequestMapping(value = "/register", method = RequestMethod.POST)
//"application/x-www-form-urlencoded;charset=UTF-8"
    //@PostMapping(value= "/register", method = RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PostMapping(value= "/register")
    public Student registerNewStudent( @RequestBody  Student student)
    {   Student createdStudent = this.studentService.registerNewStudent(student);

        return createdStudent;
    }
    @PutMapping(value = "/update/{studentId}")
    public Student updateStudent(@Valid @RequestBody  Student editedStudent,@PathVariable Integer studentId)
    {
            return this.studentService.updateStudent(editedStudent, studentId);
    }
}
