package com.springboot.lovable_clone.service;

import com.springboot.lovable_clone.dto.auth.UserProfileResponse;

public interface UserService {
    UserProfileResponse getProfile(Long userId);
}
