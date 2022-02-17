package com.example.briz.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "first_name")
    private String firstName;
    @Column (name = "middle_name")
    private String middleName;
    @Column (name = "last_name")
    private String lastName;
    @Column (name = "born_year")
    private Long bornYear;

    private String gender;
    @Column (name = "main_subject")
    private String mainSubject;
}
