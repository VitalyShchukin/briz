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
@Table(name = "grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;
    @Column(name = "mnemocode")
    private String mnemocode;
    @Column(name = "academic_year")
    private Long academicYear;
//    @Column(name = "student_id")
//    private Long studentId;
//    @Column(name = "teacher_id")
//    private Long teacherId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private List<Student> student;



    public Grade(String mnemocode, Long academicYear) {
        this.mnemocode = mnemocode;
        this.academicYear = academicYear;
    }
}

