package com.java.puzzle.springdatajpaexample.repository;

import com.java.puzzle.springdatajpaexample.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
