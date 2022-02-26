package com.example.briz.repository;

import com.example.briz.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {

    String sqlText= "SELECT " +
            "students.first_name, students.last_name, students.middle_name, " +
            "teachers.first_name, teachers.last_name, teachers.middle_name, " +
            "grades.academic_year, grades.mnemocode " +
            "FROM students " +
            "LEFT JOIN grades ON students.grade_id=grades.id " +
            "LEFT JOIN teachers ON grades.id=teachers.grade_id";

//    SELECT
//    students.first_name AS st_fn, students.last_name AS st_ln, students.middle_name AS st_mn,
//    teachers.first_name AS t_fn, teachers.last_name AS t_ln, teachers.middle_name AS t_mn,
//    grades.academic_year, grades.mnemocode
//    FROM students
//    LEFT JOIN teachers ON students.grade_id=teachers.grade_id
//    LEFT JOIN grades ON students.grade_id=grades.id

//    @Query(value =sqlText, nativeQuery = true)
//    public List<Grade> findAllRecords();

}
