package com.springboot.lovable_clone.dto.auth;

public record UserProfileResponse(
        Long id,
        String username,
        String name
) {
}
