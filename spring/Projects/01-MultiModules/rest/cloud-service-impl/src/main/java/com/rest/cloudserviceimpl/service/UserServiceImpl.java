package com.rest.cloudserviceimpl.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.rest.dto.converter.UserConverter;
import com.rest.dto.converter.UserResponseConverter;
import com.rest.dto.dto.UserRequestDto;
import com.rest.dto.dto.UserResponseDto;
import com.rest.dto.model.User;
import com.rest.serviceapi.service.UserService;
import com.rest.servicedb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserConverter userConverter;

    private final UserResponseConverter userResponseConverter;

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userResponseConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getUser(Long userid) {
        return userResponseConverter.convert(findUserById(userid));
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        return userResponseConverter.convert(userRepository.save(
                Objects.requireNonNull(userConverter.convert(userRequestDto))));
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto userRequestDto) {
        User user = findUserById(userRequestDto.getId());
        if (user != null) {
            user = userConverter.convert(userRequestDto);
        }

        assert user != null;
        return userResponseConverter.convert(userRepository.save(user));
    }

    @Override
    public boolean deleteUser(Long userid) {
        User user = findUserById(userid);
        if (user != null) {
            userRepository.delete(user);
            return true;
        } else {
            return false;
        }
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("User with that ID: %d Not found.", id)));
    }
}
