package com.spring.s3.modules.user.repository;

import com.spring.s3.modules.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByEmail(String email);
}
