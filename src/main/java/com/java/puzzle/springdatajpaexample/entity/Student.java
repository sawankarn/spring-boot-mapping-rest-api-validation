package com.java.puzzle.springdatajpaexample.entity;

import com.java.puzzle.springdatajpaexample.entity.Guardian;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_dtl",uniqueConstraints = @UniqueConstraint(
        name = "student_email_id",
        columnNames = "email_id"
))
@Builder
public class Student {
    @Id
    @SequenceGenerator(name = "student_seq", sequenceName = "student_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    private Long studentId;
    @NotNull
    @Size(min = 4, max = 15, message = "First name should be min 4 char and max 15 char.")
    private String firstName;
    @Size(min = 4, max = 15, message = "First name should be min 4 char and max 15 char.")
    private String lastName;
    @Column(name = "email_id", nullable = false)
    @Email
    private String emailId;
    @Embedded
    @Valid
    private Guardian guardian;
}
