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
@Table (name = "student")
public class Student {
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
    @ManyToOne
    private List<Group> group;

    public Student(Long id, String firstName, String middleName, String lastName, Long bornYear, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.bornYear = bornYear;
        this.gender = gender;
    }
}
