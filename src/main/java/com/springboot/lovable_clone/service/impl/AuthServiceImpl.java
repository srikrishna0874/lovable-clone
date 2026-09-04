package com.springboot.lovable_clone.service.impl;

import com.springboot.lovable_clone.dto.auth.AuthResponse;
import com.springboot.lovable_clone.dto.auth.LoginRequest;
import com.springboot.lovable_clone.dto.auth.SignupRequest;
import com.springboot.lovable_clone.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse signUp(SignupRequest signupRequest) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
