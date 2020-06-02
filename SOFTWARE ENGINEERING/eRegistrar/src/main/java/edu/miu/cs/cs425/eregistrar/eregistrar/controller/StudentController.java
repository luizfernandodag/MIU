package edu.miu.cs.cs425.eregistrar.eregistrar.controller;

import edu.miu.cs.cs425.eregistrar.eregistrar.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class StudentController {

    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/eregistrar/student/list")
    public ModelAndView lisStudent() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.getAllStudents());
        modelAndView.setViewName("student/list");
        return modelAndView;

    }
}
