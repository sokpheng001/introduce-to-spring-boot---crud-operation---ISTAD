package com.example.demo.api.v1.user.controller;

import com.example.demo.api.v1.user.model.dto.CreateUserDto;
import com.example.demo.api.v1.user.model.dto.UpdateUserDto;
import com.example.demo.api.v1.user.model.dto.UserResponseDto;
import com.example.demo.api.v1.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/users")
@RestController
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;
    @GetMapping("")
    public List<UserResponseDto> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("")
    public UserResponseDto createNewUser(
            @RequestBody CreateUserDto createUserDto){
        return userService.createNewUser(createUserDto);
    }
    @PutMapping("/{uuid}")
    public UserResponseDto updateUserByUuid(@PathVariable String uuid, @RequestBody UpdateUserDto updateUserDto){
        return userService.updateUserByUuid(uuid, updateUserDto);
    }
    @DeleteMapping("/{uuid}")
    public Integer deleteUserByUuid(@PathVariable String uuid){
        return userService.deleteUserByUuid(uuid);
    }
}
