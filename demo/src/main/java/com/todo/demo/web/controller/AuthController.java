package com.todo.demo.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.demo.domain.dto.PersonDTO;
import com.todo.demo.domain.service.jwt.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody PersonDTO request) {
        authService.registerUser(request);
        return ResponseEntity.ok("Usuario creado exitosamente");
    }

    // @PostMapping("/login")
    // public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
    //     String token = authService.authenticate(request);
    //     return ResponseEntity.ok(new AuthResponse(token));
    // }
    
    
}
