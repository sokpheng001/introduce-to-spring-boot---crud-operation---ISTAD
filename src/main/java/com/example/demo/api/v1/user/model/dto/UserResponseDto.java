package com.example.demo.api.v1.user.model.dto;

import lombok.Builder;

@Builder
public record UserResponseDto(
        String uuid,
        String name,
        String email,
        String profile,
        String bio,
        Boolean isDeleted,
        Boolean isVerified
) { }
