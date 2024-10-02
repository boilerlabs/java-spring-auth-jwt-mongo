package com.boilerlabs.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boilerlabs.auth.records.SignInRequestRecord;
import com.boilerlabs.auth.records.SignInResponseRecord;
import com.boilerlabs.auth.records.SignUpRequestRecord;
import com.boilerlabs.auth.services.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@Valid @RequestBody SignUpRequestRecord signUpRequest) {
        try {
            authService.signUp(signUpRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<SignInResponseRecord> signIn(@Valid @RequestBody SignInRequestRecord signInRequest) {
        try {
            SignInResponseRecord response = authService.signIn(signInRequest);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}