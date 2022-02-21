package com.example.briz.controller;

import com.example.briz.model.Grade;
import com.example.briz.model.Student;
import com.example.briz.repository.GradeRepository;
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
public class GradeController {
    @Autowired
    private GradeRepository gradeRepository;


    @GetMapping("/grade")
    public String findAll(Model model){
        List<Grade> grades = gradeRepository.findAll();
        model.addAttribute(grades);
        return "grade";
    }

    @PostMapping("/grade")
    public String addStudentAndTeacherToGrade(@RequestParam String mnemocode,
                                              @RequestParam Long academicYear,
                                              Model model){
        Grade grade=new Grade(mnemocode, academicYear);
        gradeRepository.save(grade);
        return "redirect:/grade";
    }
    @PostMapping("/grade/{id}/remove")
    public String deleteStudentFromGrade (@PathVariable(value="id") long id, Model model){
        Grade grade=gradeRepository.findById(id).orElseThrow();
        gradeRepository.delete(grade);
        return "redirect:/grade";
    }

}
