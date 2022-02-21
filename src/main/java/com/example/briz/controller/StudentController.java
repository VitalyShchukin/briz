package com.example.briz.controller;

import com.example.briz.model.Student;
import com.example.briz.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/student")
    public String findAllStudents(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "student";
    }

    @PostMapping("/student")
    public String addNewStudent(@RequestParam String firstName,
                                @RequestParam String middleName,
                                @RequestParam String lastName,
                                @RequestParam Long bornYear,
                                @RequestParam String gender,
                                Model model) {
        Student student=new Student(firstName, middleName, lastName, bornYear, gender);
        studentRepository.save(student);
        return "redirect:/student";
    }

    @PostMapping("/student/{id}/remove")
    public String deleteStudent(@PathVariable(value = "id") long id,Model model){
        Student student=studentRepository.findById(id).orElseThrow();
        studentRepository.delete(student);
        return "redirect:/student";
    }

}
