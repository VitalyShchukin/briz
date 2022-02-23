package com.example.briz.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "mnemocode", nullable = false)
    private String mnemocode;
    @Column(name = "academic_year", nullable = false)
    private Long academicYear;

    @OneToMany(mappedBy = "grade", orphanRemoval = true)
    private List<Teacher> teacher;

    @OneToMany(mappedBy = "grade", orphanRemoval = true)
    private List<Student> student;

    public Grade(String mnemocode, Long academicYear) {
        this.mnemocode = mnemocode;
        this.academicYear = academicYear;
    }
}

