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

    @Query(value =sqlText, nativeQuery = true)
    public List<Grade> findAllRecords();
}
