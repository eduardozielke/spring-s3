package com.spring.s3.modules.user.dto;

import com.spring.s3.enums.Gender;

public record UserRegistrationRequest(
        String name,
        String email,
        String password,
        Integer age,
        Gender gender
) {
}