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
    @Column(name = "id")
    private Long id;
    @Column(name = "mnemocode")
    private String mnemocode;
    @Column(name = "academic_year")
    private Long academicYear;

    @OneToMany(mappedBy = "grade", cascade = CascadeType.ALL)
    private List<Teacher> teacher;

    @OneToMany(mappedBy = "grade", cascade = CascadeType.ALL)
    private List<Student> student;

    public Grade(String mnemocode, Long academicYear) {
        this.mnemocode = mnemocode;
        this.academicYear = academicYear;
    }
}

