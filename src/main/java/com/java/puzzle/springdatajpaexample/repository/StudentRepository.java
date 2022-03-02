package com.java.puzzle.springdatajpaexample.repository;

import com.java.puzzle.springdatajpaexample.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    //JPA repository methods
    List<Student> findByFirstName(String firstName);
     List<Student> findByFirstNameContaining(String name);
     List<Student> findByLastNameNotNull();
    //JPA repository embedded class method
     List<Student> findByGuardianEmail(String emailId);
    //Query with JPQL
    @Query("select s from Student s where s.firstName=:firstName and s.lastName=:lastName")
    List<Student> findAllStudentDetails(String firstName, String lastName);

//    @Query with nativeQuery
    @Query(value = "SELECT * FROM schooldb.student_dtl where guardian_email=?1", nativeQuery = true)
    Student findAllByGuardianEmailIdUsingNativeQuery(String studentEmail);

    @Modifying
    @Transactional
    @Query(value = "update student_dtl set last_name=:lastName where email_id=:emailId", nativeQuery = true)
    int updateStudentWithEmail(String lastName, String emailId);
}
