package com.java.puzzle.springdatajpaexample;

import com.java.puzzle.springdatajpaexample.entity.Course;
import com.java.puzzle.springdatajpaexample.entity.Teacher;
import com.java.puzzle.springdatajpaexample.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TeacherTest {
    @Autowired
    TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
//        Course courseJava = Course.builder()
//                .title("Core Java")
//                .credit(5)
//                .build();
        Course courseBoot = Course.builder()
                .title("Spring JPA")
                .credit(7)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Sawan")
                .lastName("Kumar")
//                .courseList(List.of(courseBoot))
                .build();
        teacherRepository.save(teacher);
    }
}
