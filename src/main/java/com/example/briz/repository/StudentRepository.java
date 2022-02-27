package com.example.briz.repository;

import com.example.briz.model.Grade;
import com.example.briz.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByGrade(Grade grade);
}
