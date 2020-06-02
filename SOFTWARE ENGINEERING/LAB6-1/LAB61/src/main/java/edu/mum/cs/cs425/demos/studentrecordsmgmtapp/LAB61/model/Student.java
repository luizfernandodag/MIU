package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.LAB61.model;

import java.time.LocalDate;

public class Student {


    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", name=" + name + ", dateOfAdmission=" + dateOfAdmission + "]\n";
    }

    private Integer studentId;
    private String name;
    private LocalDate dateOfAdmission;

    //Package level constructor
    Student() {

    }

    //Package level constructor
    public Student(Integer studentId, String name, LocalDate dateOfAdmission) {
        this.studentId = studentId;
        this.name = name;
        this.dateOfAdmission = dateOfAdmission;
    }

    public Student(Integer studentId, String name, String dateOfAdmission) {
        this.studentId = studentId;
        this.name = name;
        //parse string to month day year
        String[] dates = dateOfAdmission.split("/");
        Integer day = Integer.parseInt(dates[1]);
        Integer month = Integer.parseInt(dates[0]);
        Integer year = Integer.parseInt(dates[2]);

        this.dateOfAdmission = LocalDate.of(year, month, day);
    }

    //Getters and Setters
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(LocalDate dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public void setDateOfAdmission(int month, int day, int year) {
        this.dateOfAdmission = LocalDate.of(year, month, day);
    }

}
