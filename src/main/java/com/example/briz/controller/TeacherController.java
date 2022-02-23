package com.example.briz.controller;

import com.example.briz.model.Teacher;
import com.example.briz.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    @GetMapping("/teachers")
    public String findAllTeachers(Model model) {
        List<Teacher> teachers = teacherRepository.findAll(Sort.by("lastName"));
        model.addAttribute("teachers", teachers);
        return "teachers";
    }

    @PostMapping("/teachers")
    public String addNewTeacher(@RequestParam String firstName,
                                @RequestParam String middleName,
                                @RequestParam String lastName,
                                @RequestParam(defaultValue = "0") Long bornYear,
                                @RequestParam String gender,
                                @RequestParam String mainSubject) {
        if (firstName != null && !firstName.isEmpty() && middleName != null && !middleName.isEmpty()
                && lastName != null && !lastName.isEmpty() && bornYear != 0
                && gender != null && !gender.isEmpty() && mainSubject != null && !mainSubject.isEmpty()) {
            Teacher teacher = new Teacher(firstName, middleName, lastName, bornYear, gender, mainSubject);
            teacherRepository.save(teacher);
            return "redirect:/teachers";
        } else return "redirect:/page-except";
    }

    @PostMapping("/teachers/{id}/remove")
    public String deleteTeacher(@PathVariable(value = "id") long id, Model model) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow();
        teacherRepository.delete(teacher);
        return "redirect:/teachers";
    }
}