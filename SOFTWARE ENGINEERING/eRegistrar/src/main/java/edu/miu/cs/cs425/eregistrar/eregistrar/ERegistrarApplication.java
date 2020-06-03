package edu.miu.cs.cs425.eregistrar.eregistrar;

import edu.miu.cs.cs425.eregistrar.eregistrar.model.Classroom;
import edu.miu.cs.cs425.eregistrar.eregistrar.model.Student;
import edu.miu.cs.cs425.eregistrar.eregistrar.model.Transcript;
import edu.miu.cs.cs425.eregistrar.eregistrar.repository.ClassroomRepository;
import edu.miu.cs.cs425.eregistrar.eregistrar.repository.StudentRepository;
import edu.miu.cs.cs425.eregistrar.eregistrar.repository.TranscriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;


@SpringBootApplication
public class ERegistrarApplication  implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassroomRepository classRoomRepository;
    @Autowired
    private TranscriptRepository transcriptRepository;

    private Student saveStudent(Student stu) {
        return studentRepository.save(stu);
    }

    private Transcript saveTranscript(Transcript tran)
    {
        return transcriptRepository.save(tran);
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


            Student s1 = new Student("000-61-0001", "Anna", "Lynn", "Smith", 3.45, LocalDate.of(2019, 5, 24), "no");
        Student s2 = new Student("000-61-0002", "Luiz Fernando", "de Andraden", "Gadelha", 3.45, LocalDate.of(2019, 10, 24),"yes");
        //TRANSCRIPT
        Student s3 = new Student("000-61-0003", "Luiz Fernando", "de Andraden", "Gadelha", 3.45, LocalDate.of(2019, 10, 24),"yes");
//        Transcript t = new Transcript("BS Computer Science");
//        Transcript savedTranscript = this.saveTranscript(t);
//         s1.setTranscript(savedTranscript);
//         s2.setTranscript(savedTranscript);
//         s3.setTranscript(savedTranscript);
        //LIST OF STUDENTS
//       // List<Student> listStudent = Arrays.asList(s1, s2,s3);
        //CLASS ROOM
       // Classroom clas = new Classroom("McLaughlin building", "M105", listStudent);
       // s1.setClas(clas);
        //s2.setClas(clas);s3.setClas(clas);


        //SAVE DATA

        Student savedStudent = this.saveStudent(s1);
        Student savedStudent2 = this.saveStudent(s2);
        Student savedStudent3 = this.saveStudent(s3);
        //Classroom classSaved = this.saveClassRoom(clas);
        System.out.println(savedStudent);
        //System.out.println(savedStudent2);
        //System.out.println(classSaved);


    }


}
