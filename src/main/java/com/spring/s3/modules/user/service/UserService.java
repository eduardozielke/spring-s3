package com.spring.s3.modules.user.service;

import com.spring.s3.exception.customException.DuplicateResourceException;
import com.spring.s3.modules.user.dto.UserDTO;
import com.spring.s3.modules.user.dto.UserRegistrationRequest;
import com.spring.s3.modules.user.entity.User;
import com.spring.s3.modules.user.mapper.UserDTOMapper;
import com.spring.s3.modules.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    private final UserDTOMapper userDTOMapper;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder, UserDTOMapper userDTOMapper) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.userDTOMapper = userDTOMapper;
    }

    public UserDTO create(UserRegistrationRequest request) {
        String email = request.email();
        if (repository.existsByEmail(email)) {
            throw new DuplicateResourceException("email already taken");
        }

        User user = new User(
                request.name(),
                request.email(),
                passwordEncoder.encode(request.password()),
                request.age(),
                request.gender()
        );

        final User newUser = repository.save(user);
        return userDTOMapper.apply(newUser);
    }

}
