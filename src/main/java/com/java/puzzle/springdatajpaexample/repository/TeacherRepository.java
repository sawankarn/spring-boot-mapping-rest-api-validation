package com.java.puzzle.springdatajpaexample.repository;

import com.java.puzzle.springdatajpaexample.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
