package com.example.briz.controller;

import com.example.briz.model.Teacher;
import com.example.briz.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/teacher")
    public String findAllTeachers(Model model) {
        List<Teacher> teachers = teacherRepository.findAll();
        model.addAttribute("teachers", teachers);
        return "teacher";
    }

    @PostMapping("/teacher")
    public String addNewTeacher(@RequestParam String firstName,
                                @RequestParam String middleName,
                                @RequestParam String lastName,
                                @RequestParam Long bornYear,
                                @RequestParam String gender,
                                @RequestParam String mainSubject,
                                Model model) {
        Teacher teacher = new Teacher(firstName, middleName, lastName, bornYear, gender, mainSubject);
        teacherRepository.save(teacher);
        return "redirect:/teacher";
    }

    @PostMapping("/teacher/{id}/remove")
    public String deleteTeacher(@PathVariable(value = "id") long id, Model model) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow();
        teacherRepository.delete(teacher);
        return "redirect:/teacher";
    }

}
