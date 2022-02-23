package com.example.briz.controller;

import com.example.briz.model.Grade;
import com.example.briz.model.Student;
import com.example.briz.model.Teacher;
import com.example.briz.repository.GradeRepository;
import com.example.briz.repository.StudentRepository;
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
public class GradeController {
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/grades")
    public String findAllRecords(Model model) {
//        List<Student> studentsList = studentRepository.findAll();
//        List<Teacher> teachersList = teacherRepository.findAll();
//        model.addAttribute("teachersList", teachersList);
//        model.addAttribute("studentsList", studentsList);

        List<Grade> gradeList = gradeRepository.findAllRecords();
        model.addAttribute(gradeList);
        return "grades";
    }

    @PostMapping("/grades")
    public String addingGradeToStudentAndTeacher(@RequestParam String mnemocode,
                                                 @RequestParam Long academicYear,
                                                 @RequestParam Long studentId,
                                                 @RequestParam Long teacherId,
                                                 Model model) {
        model.addAttribute("studentId", studentId);
        model.addAttribute("teacherId", teacherId);
        Grade grade = new Grade(mnemocode, academicYear);

        Student updateStudent = studentRepository.getById(studentId);
        updateStudent.setGrade(grade);
        studentRepository.save(updateStudent);

        Teacher updateTeacher = teacherRepository.getById(teacherId);
        updateTeacher.setGrade(grade);
        studentRepository.save(updateStudent);

        gradeRepository.save(grade);
        return "redirect:/grades";
    }

        @PostMapping("/grades/{id}/remove")
        public String deleteStudentFromGrade (@PathVariable(value = "id") long id, Model model){
            Grade grade = gradeRepository.findById(id).orElseThrow();
            gradeRepository.delete(grade);
            return "redirect:/grades";
        }
}