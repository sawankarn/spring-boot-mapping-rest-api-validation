package com.java.puzzle.springdatajpaexample.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(name="name",column = @Column(name = "guardian_name")),
        @AttributeOverride(name="email",column = @Column(name = "guardian_email")),
        @AttributeOverride(name="mobile",column = @Column(name = "guardian_mobile"))
})
@Builder
public class Guardian {
    private String name;
    @Email
    private String email;
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number is invalid and should be 10 digit numbers.")
    private String mobile;
}
