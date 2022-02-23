package com.example.briz.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "middle_name", nullable = false)
    private String middleName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "born_year", nullable = false)
    private Long bornYear;
    @Column(name = "gender", nullable = false)
    private String gender;
    @Column(name = "main_subject", nullable = false)
    private String mainSubject;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "grade_id")
    private Grade grade;

    public Teacher(String firstName, String middleName, String lastName, Long bornYear, String gender, String mainSubject) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.bornYear = bornYear;
        this.gender = gender;
        this.mainSubject = mainSubject;
    }
}
