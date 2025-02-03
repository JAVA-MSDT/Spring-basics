package com.rest.dto.converter;

import java.time.LocalDate;

import com.rest.dto.dto.UserRequestDto;
import com.rest.dto.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<UserRequestDto, User> {

    @Override
    public User convert(UserRequestDto userRequestDto) {
        Long id = userRequestDto.getId();
        String name = userRequestDto.getName();
        String surname = userRequestDto.getSurname();
        String birthday = userRequestDto.getBirthday();
        return new User(id, name, surname, LocalDate.parse(birthday));
    }
}
