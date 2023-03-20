package com.rest.controller;

import com.rest.cloudserviceimpl.service.UserServiceImpl;
import com.rest.dto.dto.UserRequestDto;
import com.rest.dto.dto.UserResponseDto;
import com.rest.modelassempler.UserAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    private final UserAssembler userAssembler;

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<UserResponseDto>>> getAllUsers() {
        return ResponseEntity.ok(userAssembler.toCollectionModel(userService.getAllUsers()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<UserResponseDto>> getUser(@PathVariable("id") Long userId) {
        UserResponseDto userResponseDto = userService.getUser(userId);
        EntityModel<UserResponseDto> userResponseDtoEntityModel = userAssembler.toModel(userResponseDto);
        return new ResponseEntity<>(userResponseDtoEntityModel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EntityModel<UserResponseDto>> createUser(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.createUser(userRequestDto);
        EntityModel<UserResponseDto> userResponseDtoEntityModel = userAssembler.toModel(userResponseDto);
        return new ResponseEntity<>(userResponseDtoEntityModel, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<EntityModel<UserResponseDto>> updateUser(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.updateUser(userRequestDto);
        EntityModel<UserResponseDto> userResponseDtoEntityModel = userAssembler.toModel(userResponseDto);
        return new ResponseEntity<>(userResponseDtoEntityModel, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable("id") Long userId) {
        return userService.deleteUser(userId);
    }
}
