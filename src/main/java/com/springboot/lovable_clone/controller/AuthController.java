package com.springboot.lovable_clone.controller;

import com.springboot.lovable_clone.dto.auth.AuthResponse;
import com.springboot.lovable_clone.dto.auth.LoginRequest;
import com.springboot.lovable_clone.dto.auth.SignupRequest;
import com.springboot.lovable_clone.dto.auth.UserProfileResponse;
import com.springboot.lovable_clone.service.AuthService;
import com.springboot.lovable_clone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(SignupRequest signupRequest) {
        return ResponseEntity.ok(authService.signUp(signupRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile() {
        Long userId = 1L;

        return ResponseEntity.ok(userService.getProfile(userId));
    }


}
