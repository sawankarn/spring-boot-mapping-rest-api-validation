package com.java.puzzle.springdatajpaexample;

import com.java.puzzle.springdatajpaexample.entity.Course;
import com.java.puzzle.springdatajpaexample.entity.CourseMaterial;
import com.java.puzzle.springdatajpaexample.repository.CourseMaterialRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CourseMaterialTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .title("Hibernate")
                .credit(10)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .courseUrl("google.com")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void fetchCourseMaterial(){
        List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
        System.out.println(courseMaterialList);
    }
}
