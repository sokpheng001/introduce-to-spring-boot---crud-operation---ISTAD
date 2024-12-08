package com.example.demo.api.v1.user.service;


import com.example.demo.api.v1.user.model.User;
import com.example.demo.api.v1.user.model.dto.CreateUserDto;
import com.example.demo.api.v1.user.model.dto.UpdateUserDto;
import com.example.demo.api.v1.user.model.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();
    UserResponseDto createNewUser(CreateUserDto createUserDto);
    UserResponseDto updateUserByUuid(String uuid, UpdateUserDto updateUserDto);
    Integer deleteUserByUuid(String uuid);
}
