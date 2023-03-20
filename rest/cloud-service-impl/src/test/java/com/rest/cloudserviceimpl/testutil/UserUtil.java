package com.rest.cloudserviceimpl.testutil;

import com.rest.dto.dto.UserRequestDto;
import com.rest.dto.dto.UserResponseDto;
import com.rest.dto.model.User;

import java.time.LocalDate;

public class UserUtil {

    public static final Long ID = 1L;
    public static final String NAME = "name";
    public static final String USER_NAME = "username";
    public static final LocalDate BIRTH_DATE = LocalDate.now();
    public static final String BIRTH_DATE_STRING = String.valueOf(LocalDate.now());
    public static final String USER_NOT_FOUND_EXCEPTION_MESSAGE = "User with that ID: %d Not found.";


    public static User user() {
        return new User(ID, NAME, USER_NAME, BIRTH_DATE);
    }

    public static UserResponseDto userResponseDto() {
        return new UserResponseDto(ID, NAME, USER_NAME, BIRTH_DATE_STRING);
    }

    public static UserRequestDto userRequestDto() {
        return new UserRequestDto(ID, NAME, USER_NAME, BIRTH_DATE_STRING);
    }
}
