package com.rest.dto.converter;

import com.rest.dto.dto.UserResponseDto;
import com.rest.dto.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserResponseConverter implements Converter<User, UserResponseDto> {

    @Override
    public UserResponseDto convert(User user) {
        Long id = user.getId();
        String name = user.getName();
        String surname = user.getSurname();
        String birthday = String.valueOf(user.getBirthday());
        return new UserResponseDto(id, name, surname, birthday);
    }
}
