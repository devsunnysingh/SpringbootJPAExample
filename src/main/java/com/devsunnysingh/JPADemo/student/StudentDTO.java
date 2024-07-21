package com.devsunnysingh.JPADemo.student;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;

public record  StudentDTO(
        @NotEmpty(message = "Firstname should not be empty")

        String firstName,
        @NotEmpty(message = "Lastname should not be empty")
        String lastName,
        String email, Integer schoolId
) {


}
