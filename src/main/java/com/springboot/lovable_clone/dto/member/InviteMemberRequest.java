package com.springboot.lovable_clone.dto.member;

import com.springboot.lovable_clone.enums.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole role
) {
}
