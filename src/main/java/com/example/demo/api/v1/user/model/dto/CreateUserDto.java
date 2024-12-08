package com.example.demo.api.v1.user.model.dto;

import lombok.Builder;

@Builder
public record CreateUserDto(
        String email,
        String name,
        String password
) {
}
