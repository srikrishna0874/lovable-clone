package com.springboot.lovable_clone.mapper;

import com.springboot.lovable_clone.dto.auth.SignupRequest;
import com.springboot.lovable_clone.dto.auth.UserProfileResponse;
import com.springboot.lovable_clone.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SignupRequest signupRequest);

    UserProfileResponse toUserProfileResponse(User user);
}
