package com.rest.cloudserviceimpl.service;

import com.rest.cloudserviceimpl.testutil.UserUtil;
import com.rest.dto.converter.UserConverter;
import com.rest.dto.converter.UserResponseConverter;
import com.rest.dto.dto.UserRequestDto;
import com.rest.dto.dto.UserResponseDto;
import com.rest.dto.model.User;
import com.rest.servicedb.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserConverter userConverter;
    @Mock
    private UserResponseConverter userResponseConverter;

    @Test
    void getAllUsers() {
        // Given
        User user = UserUtil.user();
        UserResponseDto userResponseDto = UserUtil.userResponseDto();

        // When
        when(userRepository.findAll()).thenReturn(List.of(user));
        when(userResponseConverter.convert(any(User.class))).thenReturn(userResponseDto);

        // Then
        List<UserResponseDto> userResponseDtos = userService.getAllUsers();
        assertEquals(userResponseDtos.size(), 1);
    }

    @Test
    void getUser() {
        // Given
        User user = UserUtil.user();
        UserResponseDto userResponseDto = UserUtil.userResponseDto();

        // When
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        when(userResponseConverter.convert(any(User.class))).thenReturn(userResponseDto);

        // Then
        UserResponseDto userServiceEntity = userService.getUser(UserUtil.ID);
        assertEquals(userResponseDto.getName(), userServiceEntity.getName());

    }

    @Test
    void createUser() {
        // Given
        User user = UserUtil.user();
        UserResponseDto userResponseDto = UserUtil.userResponseDto();
        UserRequestDto userRequestDto = UserUtil.userRequestDto();

        // When
        when(userConverter.convert(any(UserRequestDto.class))).thenReturn(user);
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userResponseConverter.convert(any(User.class))).thenReturn(userResponseDto);

        // Then
        UserResponseDto userServiceEntity = userService.createUser(userRequestDto);
        assertEquals(userResponseDto.getName(), userServiceEntity.getName());
    }

    @Test
    void updateUser() {
        // Given
        User user = UserUtil.user();
        UserResponseDto userResponseDto = UserUtil.userResponseDto();
        UserRequestDto userRequestDto = UserUtil.userRequestDto();

        // When
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        when(userConverter.convert(any(UserRequestDto.class))).thenReturn(user);
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userResponseConverter.convert(any(User.class))).thenReturn(userResponseDto);

        // Then
        UserResponseDto userServiceEntity = userService.updateUser(userRequestDto);
        assertEquals(userResponseDto.getName(), userServiceEntity.getName());
    }

    @Test
    void deleteUser_success() {
        // Given
        User user = UserUtil.user();

        // When
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));

        // Then
        boolean userDeletedStatus = userService.deleteUser(UserUtil.ID);
        assertTrue(userDeletedStatus);
    }

    @Test
    void deleteUser_fail() {
        // Given
        // When
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Then
        assertThrows(ResponseStatusException.class, () -> {
            userService.deleteUser(UserUtil.ID);
        }, String.format(UserUtil.USER_NOT_FOUND_EXCEPTION_MESSAGE, UserUtil.ID));
    }

    @Test
    void findUserById_success() {
        // Given
        User user = UserUtil.user();

        // When
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));

        // Then
        User userServiceEntity = userService.findUserById(UserUtil.ID);
        assertEquals(userServiceEntity.getName(), user.getName());
    }

    @Test
    void findUserById_fail() {
        // Given
        // When
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Then
        assertThrows(ResponseStatusException.class, () -> {
            userService.findUserById(UserUtil.ID);
        }, String.format(UserUtil.USER_NOT_FOUND_EXCEPTION_MESSAGE, UserUtil.ID));
    }
}