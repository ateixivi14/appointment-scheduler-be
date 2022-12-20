package com.training.security.repository;


import com.training.security.domain.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<ApiUser, Long> {
    
    ApiUser findByUsername(String username);
}
