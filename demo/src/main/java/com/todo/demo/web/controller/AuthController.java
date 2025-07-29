package com.todo.demo.web.controller;

import com.todo.demo.domain.dto.AuthResponseDTO;
import org.springframework.security.web.webauthn.api.AuthenticatorResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.demo.domain.dto.PersonDTO;
import com.todo.demo.domain.service.jwt.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("v1/auth")
public class AuthController {


    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponseDTO> signup(@RequestBody PersonDTO request) {
        AuthResponseDTO respose =authService.registerUserWithToken(request);
        return ResponseEntity.ok(respose);
    }

    // @PostMapping("/login")
    // public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
    //     String token = authService.authenticate(request);
    //     return ResponseEntity.ok(new AuthResponse(token));
    // }
    
    
}
