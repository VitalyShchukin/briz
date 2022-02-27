package com.example.briz.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "born_year")
    private Long bornYear;
    @Column(name = "gender")
    private String gender;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "grade_id")
    private Grade grade;

    public Student(String firstName, String middleName, String lastName, Long bornYear, String gender) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.bornYear = bornYear;
        this.gender = gender;
    }
}
