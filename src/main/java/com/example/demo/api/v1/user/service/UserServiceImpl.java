package com.example.demo.api.v1.user.service;

import com.example.demo.api.v1.user.mapper.UserMapper;
import com.example.demo.api.v1.user.model.User;
import com.example.demo.api.v1.user.model.dto.CreateUserDto;
import com.example.demo.api.v1.user.model.dto.UpdateUserDto;
import com.example.demo.api.v1.user.model.dto.UserResponseDto;
import com.example.demo.api.v1.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public List<UserResponseDto> getAllUsers() {
        List<UserResponseDto> userResponseDtos
                = new ArrayList<>();
        userRepository.userList.forEach(e->{
            userResponseDtos
                    .add(userMapper.mapFromUserToUserResponseDto(e));
        });
        return userResponseDtos;
    }


    @Override
    public UserResponseDto createNewUser(CreateUserDto createUserDto) {
        User newUser =
                userMapper.mapFromCreateUserDtoToUser(createUserDto);
        userRepository.userList.add(newUser);
        return userMapper.mapFromUserToUserResponseDto(newUser);
    }

    @Override
    public UserResponseDto updateUserByUuid(String uuid, UpdateUserDto updateUserDto) {
        User user = userRepository.userList
                .stream().filter(e->e.getUuid().equals(uuid)).toList().get(0);
        List<User> newUserList = userRepository.userList.stream().filter(e->e.getUuid().equals(uuid))
                .peek(e->{
                    if(updateUserDto.email()!="" || updateUserDto.email()!=null){
                        e.setEmail(updateUserDto.email());
                    }
                    if(updateUserDto.bio()!="" || updateUserDto.bio()!=null){
                        e.setBio(updateUserDto.bio());
                    }
                    if(updateUserDto.profile()!="" || updateUserDto.profile()!=null){
                        e.setProfile(updateUserDto.profile());
                    }
                }).toList();
        return userMapper.mapFromUserToUserResponseDto(user);
    }

    @Override
    public Integer deleteUserByUuid(String uuid) {
        User user = userRepository.userList
                .stream().filter(e->e.getUuid().equals(uuid)).toList().get(0);
        if(user!=null){
            userRepository.userList.remove(user);
            return 1;
        }
        return 0;
    }
}
