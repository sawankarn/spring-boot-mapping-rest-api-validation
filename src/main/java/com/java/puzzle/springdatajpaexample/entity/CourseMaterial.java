package com.java.puzzle.springdatajpaexample.entity;

import com.java.puzzle.springdatajpaexample.entity.Course;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @SequenceGenerator(name = "course_material_seq", sequenceName = "course_material_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_seq")
    private Long courseMaterialId;
    private String courseUrl;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "course_id", referencedColumnName = "courseId")
    private Course course;
}
