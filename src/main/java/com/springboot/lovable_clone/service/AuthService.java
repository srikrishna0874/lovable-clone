package com.springboot.lovable_clone.service;

import com.springboot.lovable_clone.dto.auth.AuthResponse;
import com.springboot.lovable_clone.dto.auth.LoginRequest;
import com.springboot.lovable_clone.dto.auth.SignupRequest;

public interface AuthService {
    AuthResponse signUp(SignupRequest signupRequest);

    AuthResponse login(LoginRequest request);
}
