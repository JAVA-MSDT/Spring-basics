package com.rest.controller;

import com.rest.cloudserviceimpl.service.UserServiceImpl;
import com.rest.dto.dto.UserRequestDto;
import com.rest.dto.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponseDto getUser(@PathVariable("id") Long userId) {
        return userService.getUser(userId);
    }

    @RequestMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }

    @RequestMapping("/update")
    public UserResponseDto updateUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.updateUser(userRequestDto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable("id") Long userId) {
        return userService.deleteUser(userId);
    }
}
