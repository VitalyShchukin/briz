package com.example.briz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table (name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mnemocode;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "teacher_id")
    private Teacher teacher;

    @OneToMany (fetch = FetchType.EAGER)
    @JoinColumn (name = "student_id")
    private Student student;

    public Group(Long id, String mnemocode) {
        this.id = id;
        this.mnemocode = mnemocode;
    }
}
