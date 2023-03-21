package com.rest.controller;

import java.util.List;
import java.util.Objects;

import com.rest.cloudserviceimpl.service.UserServiceImpl;
import com.rest.dto.dto.UserRequestDto;
import com.rest.dto.dto.UserResponseDto;
import com.rest.modelassempler.UserAssembler;
import com.rest.testutil.UserUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserServiceImpl userService;

    @Mock
    private UserAssembler userAssembler;

    @Test
    void getAllUsers() {
        // Given
        List<UserResponseDto> userResponseDtos = List.of(UserUtil.userResponseDto());
        List<EntityModel<UserResponseDto>> userResponseDtoEntityModel = List.of(
                EntityModel.of(userResponseDtos.get(0)));

        // When
        when(userService.getAllUsers()).thenReturn(userResponseDtos);
        when(userAssembler.toCollectionModel(any())).thenReturn(CollectionModel.of(userResponseDtoEntityModel));

        // Then
        ResponseEntity<CollectionModel<EntityModel<UserResponseDto>>> userResponseEntityCollection = userController.getAllUsers();
        assertEquals(userResponseEntityCollection.getStatusCode(), HttpStatus.OK);
        assertEquals(Objects.requireNonNull(userResponseEntityCollection.getBody()).getContent().size(), 1);
    }

    @Test
    void getUser() throws Exception {
        // Given
        UserResponseDto userResponseDto = UserUtil.userResponseDto();
        Long userId = UserUtil.ID;
        EntityModel<UserResponseDto> userResponseDtoEntityModel = EntityModel.of(userResponseDto);

        // When
        when(userService.getUser(anyLong())).thenReturn(userResponseDto);
        when(userAssembler.toModel(any(UserResponseDto.class))).thenReturn(userResponseDtoEntityModel);

        // Then
        ResponseEntity<EntityModel<UserResponseDto>> userResponseEntity = userController.getUser(userId);
        assertEquals(userResponseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(userResponseEntity.getBody(), userResponseDtoEntityModel);
    }

    @Test
    void createUser() {
        // Given
        UserResponseDto userResponseDto = UserUtil.userResponseDto();
        UserRequestDto userRequestDto = UserUtil.userRequestDto();

        EntityModel<UserResponseDto> userResponseDtoEntityModel = EntityModel.of(userResponseDto);

        // When
        when(userService.createUser(any(UserRequestDto.class))).thenReturn(userResponseDto);
        when(userAssembler.toModel(any(UserResponseDto.class))).thenReturn(userResponseDtoEntityModel);

        // Then
        ResponseEntity<EntityModel<UserResponseDto>> userResponseEntity = userController.createUser(userRequestDto);
        assertEquals(userResponseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(userResponseEntity.getBody(), userResponseDtoEntityModel);
    }

    @Test
    void updateUser() {
        // Given
        UserResponseDto userResponseDto = UserUtil.userResponseDto();
        UserRequestDto userRequestDto = UserUtil.userRequestDto();

        EntityModel<UserResponseDto> userResponseDtoEntityModel = EntityModel.of(userResponseDto);

        // When
        when(userService.updateUser(any(UserRequestDto.class))).thenReturn(userResponseDto);
        when(userAssembler.toModel(any(UserResponseDto.class))).thenReturn(userResponseDtoEntityModel);

        // Then
        ResponseEntity<EntityModel<UserResponseDto>> userResponseEntity = userController.updateUser(userRequestDto);
        assertEquals(userResponseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(userResponseEntity.getBody(), userResponseDtoEntityModel);
    }

    @Test
    void deleteUser() {
        // Given
        Long userId = UserUtil.ID;

        // When
        when(userService.deleteUser(anyLong())).thenReturn(true);

        // Then
        boolean userResponseDeletedStatus = userController.deleteUser(userId);
        assertTrue(userResponseDeletedStatus);
    }
}
