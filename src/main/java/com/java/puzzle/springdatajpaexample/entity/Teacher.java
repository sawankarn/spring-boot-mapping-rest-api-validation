package com.java.puzzle.springdatajpaexample.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_seq")
    @SequenceGenerator(name = "teacher_seq", sequenceName = "teacher_seq", allocationSize = 1)
    private Long teacherId;
    private String firstName;
    private String lastName;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "teacherId", referencedColumnName = "teacherId")
//    private List<Course> courseList;
}
