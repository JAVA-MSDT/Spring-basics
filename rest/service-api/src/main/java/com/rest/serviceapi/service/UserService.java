package com.rest.serviceapi.service;

import com.rest.dto.dto.UserRequestDto;
import com.rest.dto.dto.UserResponseDto;

import java.util.Collections;
import java.util.List;

public interface UserService {
    public List<UserResponseDto> getAllUsers();

    public UserResponseDto getUser(Long userid);

    public UserResponseDto createUser(UserRequestDto userRequestDto);

    public UserResponseDto updateUser(UserRequestDto userRequestDto);

    public boolean deleteUser(Long userid);
}
