package com.training.security;

import com.training.security.domain.ApiUser;
import com.training.security.domain.Role;
import com.training.security.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(1L, "ROLE_ADMIN"));
            userService.saveRole(new Role(2L, "ROLE_USER"));

            userService.saveUser(new ApiUser(1L, "ateixido", "alba", "1234", new ArrayList<>()));
            userService.saveUser(new ApiUser(2L, "lpascual", "lucas", "1234", new ArrayList<>()));

            userService.addRoleToUser("lpascual", "ROLE_USER");
            userService.addRoleToUser("ateixido", "ROLE_ADMIN");
        };
    }

}
