package com.rest.serviceapi.service;

import java.util.List;

import com.rest.dto.dto.UserRequestDto;
import com.rest.dto.dto.UserResponseDto;

public interface UserService {
    public List<UserResponseDto> getAllUsers();

    public UserResponseDto getUser(Long userid);

    public UserResponseDto createUser(UserRequestDto userRequestDto);

    public UserResponseDto updateUser(UserRequestDto userRequestDto);

    public boolean deleteUser(Long userid);
}
