package com.example.demo.api.v1.user.model.dto;

import lombok.Builder;

@Builder
public record UpdateUserDto(
        String email,
        String profile,
        String bio
) {
}
