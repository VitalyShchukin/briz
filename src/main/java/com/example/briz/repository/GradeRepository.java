package com.example.briz.repository;

import com.example.briz.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {

//    @Query(value = "SELECT * FROM grade LEFT JOIN student ON grade.student_id=student.id " +
//            "LEFT JOIN teacher ON grade.teacher_id=teacher.id",
//            nativeQuery = true)
//    public List<Grade> findAll();
}
