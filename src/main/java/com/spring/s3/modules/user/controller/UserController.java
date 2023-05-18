package com.spring.s3.modules.user.controller;

import com.spring.s3.modules.user.dto.UserDTO;
import com.spring.s3.modules.user.dto.UserRegistrationRequest;
import com.spring.s3.modules.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserRegistrationRequest request) {
        UserDTO createUserDTO = service.create(request);
        return new ResponseEntity<>(createUserDTO, HttpStatus.CREATED);
    }
}
