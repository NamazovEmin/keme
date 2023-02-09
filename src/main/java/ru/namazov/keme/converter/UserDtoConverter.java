package ru.namazov.keme.converter;

import org.springframework.stereotype.Component;

import ru.namazov.keme.dto.UserDto;
import ru.namazov.keme.entity.User;


@Component
public class UserDtoConverter {

    public User fromDto(UserDto userDto) {
        return new User(
                userDto.getName(),
                userDto.getPassword(),
                userDto.getEmail()
        );
    }

    public UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getPassword(),
                user.getEmail()
        );
    }
}
