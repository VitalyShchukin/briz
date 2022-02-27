package com.example.briz.modelView;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GradeTableRow {
    private Long id;
    private String teacherName;
    private String studentName;
    private Long studentBornYear;

    private Long gradeAcademicYear;
    private String gradeMnemocode;
}
