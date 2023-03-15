package com.rest.cloudserviceimpl.service;

import com.rest.dto.dto.UserRequestDto;
import com.rest.dto.dto.UserResponseDto;
import com.rest.serviceapi.service.UserService;

import java.util.Collections;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<UserResponseDto> getAllUsers() {
        return Collections.emptyList();
    }

    @Override
    public UserResponseDto getUser(Long userid) {
        return new UserResponseDto();
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        return new UserResponseDto();
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto userRequestDto) {
        return new UserResponseDto();
    }

    @Override
    public void deleteUser(Long userid) {

    }
}
