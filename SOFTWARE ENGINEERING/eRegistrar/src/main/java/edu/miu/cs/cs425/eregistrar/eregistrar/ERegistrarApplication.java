package edu.miu.cs.cs425.eregistrar.eregistrar;

import edu.miu.cs.cs425.eregistrar.eregistrar.model.Classroom;
import edu.miu.cs.cs425.eregistrar.eregistrar.model.Student;
import edu.miu.cs.cs425.eregistrar.eregistrar.model.Transcript;
import edu.miu.cs.cs425.eregistrar.eregistrar.repository.ClassroomRepository;
import edu.miu.cs.cs425.eregistrar.eregistrar.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class ERegistrarApplication  implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassroomRepository classRoomRepository;

    private Student saveStudent(Student stu) {
        return studentRepository.save(stu);
    }

    private Classroom saveClassRoom(Classroom clas) {
        return this.classRoomRepository.save(clas);
    }

    public static void main(String[] args) {
        SpringApplication.run(ERegistrarApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
		/*public Student(@NotBlank(message = "studentNumber (NNN-NN-NNNN format)") String studentNumber,
				@NotBlank(message = "First name is required") String firstName, String middleName,
				@NotBlank(message = "Last name is required") String lastName, Float cpga,
				@NotBlank(message = "Last name is required") LocalDate dateOfEnrollment) */
        //STUDENTS
        Student s1 = new Student("000-61-0001", "Anna", "Lynn", "Smith", 3.45, LocalDate.of(2019, 5, 24));
        Student s2 = new Student("000-61-0002", "Luiz Fernando", "de Andraden", "Gadelha", 3.45, LocalDate.of(2019, 10, 24));
        //TRANSCRIPT
        Transcript t = new Transcript("BS Computer Science");
        s1.setTranscript(t);
        s2.setTranscript(t);
        //LIST OF STUDENTS
        List<Student> listStudent = Arrays.asList(s1, s2);
        //CLASS ROOM
        Classroom clas = new Classroom("McLaughlin building", "M105", listStudent);
        s1.setClas(clas);
        s2.setClas(clas);


        //SAVE DATA

        Student savedStudent = this.saveStudent(s1);
        Student savedStudent2 = this.saveStudent(s2);
        Classroom classSaved = this.saveClassRoom(clas);
        //System.out.println(savedStudent);
        //System.out.println(savedStudent2);
        System.out.println(classSaved);


    }


}
