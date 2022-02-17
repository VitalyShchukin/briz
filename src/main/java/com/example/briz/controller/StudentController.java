package com.example.briz.controller;

import com.example.briz.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

}
