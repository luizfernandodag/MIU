package edu.cs.cs425.eregistrarwebapi.eregistrarwebapi.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "classrooms")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="classroom")
    private Long classroomId;

    private String buildingName;
    private String roomNumber;

    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "classroomId",nullable=true)
//    @OneToMany(mappedBy = "clas",
//            orphanRemoval = true,
//            cascade = CascadeType.ALL)
//    private List<Student> studentsList;


    public Classroom(Long classroomId, String buildingName, String roomNumber, List<Student> studentsList) {

        this.classroomId = classroomId;
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;

    }


//    public Classroom(String buildingName, String roomNumber, List<Student> studentsList) {
//
//
//        this.buildingName = buildingName;
//        this.roomNumber = roomNumber;
//        this.studentsList = studentsList;
//    }
//
//    public Classroom(String buildingName, String roomNumber) {
//
//
//        this.buildingName = buildingName;
//        this.roomNumber = roomNumber;
//
//    }


    public Classroom() {

    }

    public Classroom(Long classroomId, String buildingName, String roomNumber) {
        this.classroomId = classroomId;
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
    }


    public Long getClassroomId() {
        return classroomId;
    }


    public void setClassroomId(Long classroomId) {
        this.classroomId = classroomId;
    }


    public String getBuildingName() {
        return buildingName;
    }


    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }


    public String getRoomNumber() {
        return roomNumber;
    }


    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }


//    public List<Student> getStudentsList() {
//        return studentsList;
//    }
//
//
//    public void setStudentsList(List<Student> studentsList) {
//        this.studentsList = studentsList;
//    }





}
