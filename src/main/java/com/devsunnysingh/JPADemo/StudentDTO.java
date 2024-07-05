package com.devsunnysingh.JPADemo;

import jakarta.persistence.Column;

public record StudentDTO(String firstName,
        String lastName,
        String email, Integer schoolId
) {


}
