package com.training.security.controller;

import com.training.security.domain.ApiUser;
import com.training.security.domain.Role;
import com.training.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;
    
    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<ApiUser>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }
    
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void saveUser(ApiUser user){
        userService.saveUser(user);
    }
    
    @PostMapping("/role")
    @PreAuthorize("hasRole('ADMIN')")
    public void saveRole(Role role) {
        userService.saveRole(role);
    }
    
}
