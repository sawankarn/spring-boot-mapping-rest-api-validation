package com.java.puzzle.springdatajpaexample.service;

import com.java.puzzle.springdatajpaexample.entity.Student;
import com.java.puzzle.springdatajpaexample.exception.StudentNotFoundException;
import com.java.puzzle.springdatajpaexample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public ResponseEntity<Student> findStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()->new StudentNotFoundException("Student id::"+studentId+" is not present."));
//        if(!student.isPresent()) throw new StudentNotFoundException("Student id::"+studentId+" is not present.")
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    public ResponseEntity<Student> saveStudentDetails(Student student) {
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.CREATED);
    }

    public ResponseEntity<Student> updateStudentDetails(Student studentData, Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()->new StudentNotFoundException("Student id::"+studentId+" is not present."));
        studentData.setStudentId(studentId);
        return new ResponseEntity<>(studentRepository.save(studentData), HttpStatus.ACCEPTED);
    }

    public ResponseEntity<String> deleteStudentDetails(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()->new StudentNotFoundException("Student id::"+studentId+" is not present."));
        studentRepository.deleteById(studentId);
        return ResponseEntity.ok().body("Student id ::"+studentId+" deleted successfully.");
    }
}
