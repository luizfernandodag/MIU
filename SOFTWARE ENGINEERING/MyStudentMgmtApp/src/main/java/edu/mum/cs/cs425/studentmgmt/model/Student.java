package edu.mum.cs.cs425.studentmgmt.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long studentId;
	
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
	private LocalDate dateOfEnrollment;
	
	@OneToOne(cascade = CascadeType.ALL)
	//@OneToOne
	@JoinColumn(name="transcript", referencedColumnName="transcriptId",nullable=true)   
	private Transcript transcript;
	
	
	public Long getStudentId() {
		return studentId;
	}


	public void setStudentId(Long studentId) {
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
	
	public Student(@NotBlank(message = "studentNumber (NNN-NN-NNNN format)") String studentNumber,
			@NotBlank(message = "First name is required") String firstName, String middleName,
			@NotBlank(message = "Last name is required") String lastName, Double cpga,
			@NotBlank(message = "Last name is required") LocalDate dateOfEnrollment,
			Transcript transcript) {
		super();
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cpga = cpga;
		this.dateOfEnrollment = dateOfEnrollment;
		this.transcript = transcript;
	}


	public Student() {
		super();
	}



	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentNumber=" + studentNumber + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", cpga=" + cpga + ", dateOfEnrollment="
				+ dateOfEnrollment + "]";
	}


	public Transcript getTranscript() {
		return transcript;
	}


	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}
	

}
