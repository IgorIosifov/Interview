package com.geekbrains.controllers;

import com.geekbrains.entities.Student;
import com.geekbrains.repositories.StudentRepository;
import com.geekbrains.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String allStudents(Model model) {
        List<Student> students = studentService.findAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(Model model, @PathVariable Long id) {
        Optional<Student> student = studentService.findStudentById(id);
        model.addAttribute("student", student);
        return "student_edit";
    }

    @PostMapping("/edit")
    public String saveChanges(@ModelAttribute(name = "student") Student student) {
        studentService.save(student);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/";
    }

    @PostMapping("/new")
    public String newStudent(@ModelAttribute(name = "student") Student student) {
        System.out.println("asd");
        studentService.save(student);
        return "redirect:/";
    }
}
