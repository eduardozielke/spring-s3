package com.spring.s3.modules.user.dto;

import com.spring.s3.enums.Gender;

import java.util.List;

public record UserDTO(
        Integer id,
        String name,
        String email,
        Gender gender,
        Integer age,
        List<String> roles,
        String username,
        String profileImageId
) {

}
