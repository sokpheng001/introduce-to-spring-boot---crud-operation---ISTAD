package com.example.demo.api.v1.user.mapper;

import com.example.demo.api.v1.user.model.User;
import com.example.demo.api.v1.user.model.dto.CreateUserDto;
import com.example.demo.api.v1.user.model.dto.UpdateUserDto;
import com.example.demo.api.v1.user.model.dto.UserResponseDto;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
public class UserMapper {
    public UserResponseDto mapFromUserToUserResponseDto(User user){
        return UserResponseDto.builder()
                .uuid(user.getUuid())
                .name(user.getName())
                .email(user.getEmail())
                .profile(user.getProfile())
                .bio(user.getBio())
                .isDeleted(user.getIsDeleted())
                .isVerified(user.getIsVerified())
                .build();
    }
    public User mapFromCreateUserDtoToUser(CreateUserDto cr){
        return new User(new Random().nextInt(999999), UUID.randomUUID().toString(),cr.name(), cr.email(), cr.password(),"","",false,true);
    }

}
