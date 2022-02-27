package com.example.briz.controller;

import com.example.briz.model.Student;
import com.example.briz.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.IntStream;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public String findAllStudents(@RequestParam(value="page", defaultValue = "0") int page,
                                  Model model) {

        Page<Student> allStudents = studentRepository.findAll(PageRequest.of(page, 10, Sort.by("lastName")));
        int totalPages=allStudents.getTotalPages();

        model.addAttribute("totalPages", totalPages);
        model.addAttribute("allStudents", allStudents);
        model.addAttribute("numbers", IntStream.range(0, totalPages).toArray());
        return "students";
    }

    @PostMapping("/students")
    public String addNewStudent(@RequestParam String firstName,
                                @RequestParam String middleName,
                                @RequestParam String lastName,
                                @RequestParam(defaultValue = "0") Long bornYear,
                                @RequestParam String gender) {
        if (firstName != null && !firstName.isEmpty() && middleName != null && !middleName.isEmpty()
                && lastName != null && !lastName.isEmpty() && bornYear != 0
                && gender != null && !gender.isEmpty()) {
            Student student = new Student(firstName, middleName, lastName, bornYear, gender);
            studentRepository.save(student);
            return "redirect:/students";
        } else return "redirect:/page-except";
    }

    @PostMapping("/students/{id}/remove")
    public String deleteStudent(@PathVariable(value = "id") long id, Model model) {
        Student student = studentRepository.findById(id).orElseThrow(()->new RuntimeException("not found this student with id - "+id));
        studentRepository.delete(student);
        return "redirect:/students";
    }
}
