package ru.namazov.keme.converter;

import org.springframework.stereotype.Component;

import ru.namazov.keme.dto.UserDto;
import ru.namazov.keme.dto.UserNewDto;
import ru.namazov.keme.entity.User;

@Component
public class UserDtoConverterImpl implements UserDtoConverter {

    @Override
    public User toEntity(UserNewDto userNewDto) {
        return new User(
                userNewDto.getName(),
                userNewDto.getPassword(),
                userNewDto.getEmail()
        );
    }

    @Override
    public UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getPassword(),
                user.getEmail()
        );
    }
}