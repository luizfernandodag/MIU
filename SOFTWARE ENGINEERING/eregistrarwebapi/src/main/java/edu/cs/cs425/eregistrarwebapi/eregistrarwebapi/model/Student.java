package edu.cs.cs425.eregistrarwebapi.eregistrarwebapi.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;


@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @NotBlank(message = "studentNumber (NNN-NN-NNNN format)")
    private String studentNumber;
    @NotBlank(message = "First name is required")
    private String firstName;
    //OPTIONAL
    private String middleName;

    @NotBlank(message = "Last name is required")
    private String lastName;
    //OPTIONAL
    private Double cpga;
    @NotBlank(message = "Last name is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfEnrollment;

    @NotBlank(message = "Nationality is required")
    private String isInternational;
    //List<String> internationalList;

    public Student(@NotBlank(message = "First name is required") String firstName) {
        this.firstName = firstName;
    }

    public Student(@NotBlank(message = "studentNumber (NNN-NN-NNNN format)") String studentNumber,
                   @NotBlank(message = "First name is required") String firstName, String middleName,
                   @NotBlank(message = "Last name is required") String lastName, Double cpga,
                   @NotBlank(message = "Last name is required") LocalDate dateOfEnrollment,
                   @NotBlank(message = "isInternational is required") String isInternational) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cpga = cpga;
        this.dateOfEnrollment = dateOfEnrollment;
        this.isInternational = isInternational;


    }

    /*@OneToOne(cascade = CascadeType.DETACH)
    //@OneToOne
    @JoinColumn(name = "transcript",nullable = true)
    private Transcript transcript;*/


//	//@Column(name="classroom")
//	@ManyToOne(cascade = CascadeType.ALL)
//   // @JoinColumn(name="classroom_id",nullable = true)

    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name="published_by", referencedColumnName="publisherId",nullable=false)//FK collumn
    //private Publisher publishedBy;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "clas", referencedColumnName = "classroomId", nullable = true)//FK collumn
//    private Classroom clas;
//


    public Integer getStudentId() {
        return studentId;
    }


    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }


    public String getStudentNumber() {
        return studentNumber;
    }


    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getMiddleName() {
        return middleName;
    }


    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Double getCpga() {
        return cpga;
    }


    public void setCpga(Double cpga) {
        this.cpga = cpga;
    }


    public LocalDate getDateOfEnrollment() {
        return dateOfEnrollment;
    }


    public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }


    public Student(@NotBlank(message = "studentNumber (NNN-NN-NNNN format)") String studentNumber,
                   @NotBlank(message = "First name is required") String firstName, String middleName,
                   @NotBlank(message = "Last name is required") String lastName, Double cpga,
                   @NotBlank(message = "Last name is required") LocalDate dateOfEnrollment) {
        super();
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cpga = cpga;
        this.dateOfEnrollment = dateOfEnrollment;
    }
//
//    public Student(@NotBlank(message = "studentNumber (NNN-NN-NNNN format)") String studentNumber,
//                   @NotBlank(message = "First name is required") String firstName, String middleName,
//                   @NotBlank(message = "Last name is required") String lastName, Double cpga,
//                   @NotBlank(message = "Last name is required") LocalDate dateOfEnrollment,
//                   Transcript transcript) {
//        super();
//        this.studentNumber = studentNumber;
//        this.firstName = firstName;
//        this.middleName = middleName;
//        this.lastName = lastName;
//        this.cpga = cpga;
//        this.dateOfEnrollment = dateOfEnrollment;
//        this.transcript = transcript;
//    }

//    public Student(@NotBlank(message = "studentNumber (NNN-NN-NNNN format)") String studentNumber,
//                   @NotBlank(message = "First name is required") String firstName, String middleName,
//                   @NotBlank(message = "Last name is required") String lastName, Double cpga,
//                   @NotBlank(message = "Last name is required") LocalDate dateOfEnrollment,
//                   Transcript transcript,
//                   Classroom classroom) {
//        super();
//        this.studentNumber = studentNumber;
//        this.firstName = firstName;
//        this.middleName = middleName;
//        this.lastName = lastName;
//        this.cpga = cpga;
//        this.dateOfEnrollment = dateOfEnrollment;
//        this.transcript = transcript;
//        this.clas = classroom;
//    }


    public Student() {
        super();
    }


    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", studentNumber=" + studentNumber + ", firstName=" + firstName
                + ", middleName=" + middleName + ", lastName=" + lastName + ", cpga=" + cpga + ", dateOfEnrollment="
                + dateOfEnrollment + "]";
    }


    public String getIsInternational() {
        return isInternational;
    }

    public void setIsInternational(String isInternational) {
        this.isInternational = isInternational;
    }
}
