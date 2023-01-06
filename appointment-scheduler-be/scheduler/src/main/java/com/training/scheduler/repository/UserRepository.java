package com.training.scheduler.repository;


import com.training.scheduler.domain.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<ApiUser, Long> {
    
    boolean existsApiUserByUsername(String username);
    ApiUser findByUsername(String username);
}
