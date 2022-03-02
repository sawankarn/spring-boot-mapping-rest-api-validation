package com.java.puzzle.springdatajpaexample.repository;

import com.java.puzzle.springdatajpaexample.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
