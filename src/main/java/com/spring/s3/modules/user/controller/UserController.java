package com.spring.s3.modules.user.controller;

import jakarta.persistence.Column;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class UserController {

    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(
            nullable = false
    )
    private String password;

    @Column(
            unique = true
    )
    private String profileImageId;

}
