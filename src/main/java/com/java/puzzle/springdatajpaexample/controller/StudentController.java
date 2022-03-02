package com.java.puzzle.springdatajpaexample.controller;

import com.java.puzzle.springdatajpaexample.entity.Student;
import com.java.puzzle.springdatajpaexample.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    List<Student> findAllStudents(){
        return studentService.findAllStudents();
    }

    @GetMapping("/student/{studentId}")
    ResponseEntity<Student> findStudentById(@PathVariable("studentId") Long studentId){
        return studentService.findStudentById(studentId);
    }

    @PostMapping("/student")
    ResponseEntity<Student> saveStudentDetails(@RequestBody @Valid Student student){
        return studentService.saveStudentDetails(student);
    }

    @PutMapping("/student/{studentId}")
    ResponseEntity<Student> updateStudentDetails(@RequestBody @Valid Student student,
                                                 @PathVariable("studentId") Long studentId){
        return studentService.updateStudentDetails(student, studentId);
    }

    @DeleteMapping("/student/{studentId}")
    ResponseEntity<String> deleteStudentDetails(@PathVariable("studentId") Long studentId){
        return studentService.deleteStudentDetails(studentId);
    }
}
