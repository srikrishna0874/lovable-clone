package com.springboot.lovable_clone.service.impl;

import com.springboot.lovable_clone.dto.auth.AuthResponse;
import com.springboot.lovable_clone.dto.auth.LoginRequest;
import com.springboot.lovable_clone.dto.auth.SignupRequest;
import com.springboot.lovable_clone.entity.User;
import com.springboot.lovable_clone.error.BadRequestException;
import com.springboot.lovable_clone.mapper.UserMapper;
import com.springboot.lovable_clone.repository.UserRepository;
import com.springboot.lovable_clone.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse signUp(SignupRequest signupRequest) {

        userRepository.findByUsername(signupRequest.username()).ifPresent(user -> {
            throw new BadRequestException("User already exists with username " + signupRequest.username());
        });

        User user = userMapper.toEntity(signupRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);

        return new AuthResponse("dummy", userMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
