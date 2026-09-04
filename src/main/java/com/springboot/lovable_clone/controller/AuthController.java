package com.springboot.lovable_clone.controller;

import com.springboot.lovable_clone.dto.auth.AuthResponse;
import com.springboot.lovable_clone.dto.auth.LoginRequest;
import com.springboot.lovable_clone.dto.auth.SignupRequest;
import com.springboot.lovable_clone.dto.auth.UserProfileResponse;
import com.springboot.lovable_clone.service.AuthService;
import com.springboot.lovable_clone.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthController {

    AuthService authService;

    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(@RequestBody SignupRequest signupRequest) {
        return ResponseEntity.ok(authService.signUp(signupRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile() {
        Long userId = 1L;

        return ResponseEntity.ok(userService.getProfile(userId));
    }


}
