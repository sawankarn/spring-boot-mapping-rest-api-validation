package com.java.puzzle.springdatajpaexample;

import com.java.puzzle.springdatajpaexample.entity.Course;
import com.java.puzzle.springdatajpaexample.entity.Teacher;
import com.java.puzzle.springdatajpaexample.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CourseTest {
    @Autowired
    CourseRepository courseRepository;

    @Test
    public void printCourseData(){
        List<Course> courseList = courseRepository.findAll();
        System.out.println("courseList:::"+courseList);
    }

    @Test
    public void saveTeacherWithCourse(){
        Teacher teacher = Teacher.builder()
                .firstName("Ganesh")
                .lastName("Kumar")
                .build();
        Course course = Course.builder()
                .title("Spring Data JPA111")
                .credit(15)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }



}
