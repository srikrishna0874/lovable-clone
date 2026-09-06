package com.springboot.lovable_clone.dto.member;

import com.springboot.lovable_clone.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateRoleRequest(

        @NotNull
        ProjectRole role
) {
}
