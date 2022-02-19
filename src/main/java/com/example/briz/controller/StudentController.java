package com.example.briz.controller;

import com.example.briz.model.Student;
import com.example.briz.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/student")
    public String findAllStudents(Model model){
        List<Student> list=studentRepository.findAll();
        model.addAttribute("list", list);
        return "student";
    }

}
