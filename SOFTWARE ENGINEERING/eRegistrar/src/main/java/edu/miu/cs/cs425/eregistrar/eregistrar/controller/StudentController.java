package edu.miu.cs.cs425.eregistrar.eregistrar.controller;

import edu.miu.cs.cs425.eregistrar.eregistrar.model.Student;
import edu.miu.cs.cs425.eregistrar.eregistrar.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = {"/eregistrar/student/list", "/student/list"})
    public ModelAndView lisStudent() {
        ModelAndView modelAndView = new ModelAndView();

        List<Student> students = studentService.getAllStudents();
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", "");
        modelAndView.addObject("studentsCount", students.size());
        modelAndView.setViewName("student/list");
        return modelAndView;

    }

    @GetMapping(value = {"/eregistrar/student/new","/student/new"})
    public String displayNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/new";
    }


    @PostMapping(value = {"/eregistrar/student/new","/student/new"})
    public String addNewStudent(@Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/new";
        }
        student = studentService.saveStudent(student);
        return "redirect:/eregistrar/student/list";
    }

    @GetMapping(value = {"/eregistrar/student/edit/{studentId}","/student/edit/{studentId}"})
    public String editStudent(@PathVariable Integer studentId, Model model) {
        Student student = studentService.getStudentById  (studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "student/edit";
        }
        return "student/list";
    }

    @PostMapping(value = {"/eregistrar/student/edit","/student/edit"})
    public String updateStudent(@Valid @ModelAttribute("student") Student student,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/edit";
        }
        student = studentService.saveStudent(student);
        return "redirect:/eregistrar/student/list";
    }

    @GetMapping(value = {"/eregistrar/student/delete/{studentId}","/student/delete/{studentId}"})
    public String deleteStudent(@PathVariable Integer studentId, Model model) {
        studentService.deleteStudentById(studentId);
        return "redirect:/eregistrar/student/list";

    }

    @GetMapping(value = {"/eregistrar/student/search", "/student/search"})
    public ModelAndView searchStudents(@RequestParam String searchString) {
        ModelAndView modelAndView = new ModelAndView();

        List<Student> students = studentService.searchStudents(searchString);

        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", searchString);
        modelAndView.addObject("StudentsCount", students.size());
        modelAndView.setViewName("student/list");
        return modelAndView;
    }

    @ModelAttribute("isInternationalList")
    public List<String> populateInternationaList() {
        List<String> nationalities = new ArrayList<String>();
        nationalities.add("no");
        nationalities.add("yes");
        return nationalities;
    }
}
