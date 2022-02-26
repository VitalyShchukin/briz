package com.example.briz.modelView;

import lombok.Data;

@Data
public class GradeTableRow {
    private Long id;
    private String teacherName;
    private String studentName;
    private Long studentBornYear;

    private Long gradeAcademicYear;
    private String gradeMnemocode;
}
