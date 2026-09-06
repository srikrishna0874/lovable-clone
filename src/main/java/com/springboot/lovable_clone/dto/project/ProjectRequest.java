package com.springboot.lovable_clone.dto.project;

import jakarta.validation.constraints.NotBlank;

public record ProjectRequest(

        @NotBlank
        String name
) {
}
