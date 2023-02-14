package ru.namazov.keme.converter;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ru.namazov.keme.dto.UserDto;
import ru.namazov.keme.dto.UserNewDto;
import ru.namazov.keme.entity.User;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserDtoConverterImpl implements UserDtoConverter {

    private final PasswordEncoder passwordEncoder;

    @Override
    public User toEntity(UserNewDto userNewDto) {
        String hashedPassword = passwordEncoder.encode(userNewDto.getPassword());
        return new User(
                userNewDto.getName(),
                hashedPassword,
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
