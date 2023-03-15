package com.rest.controller;

import com.rest.cloudserviceimpl.service.UserServiceImpl;
import com.rest.dto.dto.UserRequestDto;
import com.rest.dto.dto.UserResponseDto;

import java.util.Collections;
import java.util.List;

public class UserController {
    private UserServiceImpl userService;

    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

    public UserResponseDto getUser(Long userid) {
        return userService.getUser(userid);
    }

    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }

    public UserResponseDto updateUser(UserRequestDto userRequestDto) {
        return userService.updateUser(userRequestDto);
    }

    public void deleteUser(Long userid) {
        userService.deleteUser(userid);
    }
}
