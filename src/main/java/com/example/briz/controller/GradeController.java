package com.example.briz.controller;

import com.example.briz.model.Grade;
import com.example.briz.model.Student;
import com.example.briz.model.Teacher;
import com.example.briz.modelView.GradeTableRow;
import com.example.briz.repository.GradeRepository;
import com.example.briz.repository.StudentRepository;
import com.example.briz.repository.TeacherRepository;
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

import java.util.ArrayList;
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
    public String findAllRecords(@RequestParam(value = "page", defaultValue = "0") int page,
                                 Model model) {
        List<Student> studentsList = studentRepository.findAll();
        List<Teacher> teachersList = teacherRepository.findAll();
        model.addAttribute("teachersList", teachersList);
        model.addAttribute("studentsList", studentsList);

        List<GradeTableRow> gradeTableRow = new ArrayList<>();
        Page<Grade> gradeList = gradeRepository.findAll(PageRequest.of(page, 10, Sort.by("mnemocode")));
        gradeList.forEach(item -> {
            GradeTableRow tableRow = new GradeTableRow();

            tableRow.setId(item.getId());
            tableRow.setGradeMnemocode(item.getMnemocode());
            tableRow.setGradeAcademicYear(item.getAcademicYear());

            if (!item.getTeacher().isEmpty()) {
                Teacher teacher = item.getTeacher().get(0);
                tableRow.setTeacherName(teacher.getFirstName() + " " + teacher.getMiddleName() + " " + teacher.getLastName());
            }
            if (!item.getStudent().isEmpty()) {
                Student student = item.getStudent().get(0);
                tableRow.setStudentName(student.getFirstName() + " " + student.getMiddleName() + " " + student.getLastName());
                tableRow.setStudentBornYear(student.getBornYear());
            }
            gradeTableRow.add(tableRow);
        });
        model.addAttribute("gradeTableRow", gradeTableRow);
        return "grades";
    }

    @PostMapping("/grades")
    public String addingGradeToStudentAndTeacher(@RequestParam(defaultValue = "0") String mnemocode,
                                                 @RequestParam(defaultValue = "0") Long academicYear,
                                                 @RequestParam(defaultValue = "0") Long studentId,
                                                 @RequestParam(defaultValue = "0") Long teacherId,
                                                 Model model) {
        model.addAttribute("studentId", studentId);
        model.addAttribute("teacherId", teacherId);

        if (mnemocode != null && !mnemocode.isEmpty() && academicYear != 0
                && studentId != 0 && teacherId != 0) {

            Grade grade = new Grade(mnemocode, academicYear);
            gradeRepository.save(grade);

            Student updateStudent = studentRepository.getById(studentId);
            updateStudent.setGrade(grade);
            studentRepository.save(updateStudent);

            Teacher updateTeacher = teacherRepository.getById(teacherId);
            updateTeacher.setGrade(grade);
            studentRepository.save(updateStudent);

            return "redirect:/grades";
        } else return "redirect:/page-except";
    }

    @PostMapping("/grades/{id}/remove")
    public String deleteStudentFromGrade(@PathVariable(value = "id") long id, Model model) {
        Grade grade = gradeRepository.findById(id).orElseThrow(() -> new RuntimeException("not found this grade with id- " + id));
        gradeRepository.delete(grade);
        return "redirect:/grades";
    }
}