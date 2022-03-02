package com.java.puzzle.springdatajpaexample;

import com.java.puzzle.springdatajpaexample.entity.Guardian;
import com.java.puzzle.springdatajpaexample.entity.Student;
import com.java.puzzle.springdatajpaexample.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentTest {
    @Autowired
    private StudentRepository studentRepository;

    //pre-defined repository methods
    @Test
    public void saveStudentDetails(){
//        Student student = new Student();
//        student.setEmailId("sai_ganesh@demo.com");
//        student.setFirstName("Sai");
//        student.setLastName("Ganesh");
//        student.setGuardianName("ABC");
//        student.setGuardianEmail("abc@demo.com");
//        student.setGuardianMobile("123456789");
        Student student = Student.builder()
                .firstName("Sai")
                .lastName("Ganesh")
                .emailId("sai_ganesh@demo.com")
//                .guardianEmail("abc@gmail.com")
//                .guardianMobile("123456789")
//                .guardianName("ABC")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentDetailsWithGuardianClass(){
        Guardian guardian = Guardian.builder()
                .name("guardian")
                .email("guardian@email.com")
                .mobile("1234567890")
                .build();
        Student student = Student.builder()
                .firstName("Sawan")
                .lastName("Kumar")
                .emailId("sawan_kumar@demo.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void getAllStudentDetails(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList:::"+studentList);
    }

    // custom repostiory method
    @Test
    public void findByFirstNameCustomMethod(){
        List<Student> studentList = studentRepository.findByFirstName("Sawan");
        System.out.println("studentList:::"+studentList);
    }

    @Test
    public void findByFirstNameCustomMethodContaining(){
        List<Student> studentList = studentRepository.findByLastNameNotNull();
        System.out.println("studentList:::"+studentList);
    }

    //repository method with embeddable class
    @Test
    public void findByGuardianEmailEmbedded(){
        List<Student> studentList = studentRepository.findByGuardianEmail("guardian@email.com");
        System.out.println("studentList:::"+studentList);
    }

    @Test
    public void findAllStudentUsingJPQL(){
        List<Student> studentList = studentRepository.findAllStudentDetails("Sai", "Ganesh");
        System.out.println("studentList:::"+studentList);
    }

    @Test
    public void findStudentByEmailUsingNativeQuery(){
        Student student = studentRepository.findAllByGuardianEmailIdUsingNativeQuery("abc@gmail.com");
        System.out.println("Students::"+student);
    }

    @Test
    public void updateStudentDtlsWithEmailId(){
        int updateStudent = studentRepository.updateStudentWithEmail("Kumar", "sawan_kumar@demo.com");
        System.out.println("student updated successfully:::"+updateStudent);
    }

}
