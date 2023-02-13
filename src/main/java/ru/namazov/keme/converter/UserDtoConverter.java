package ru.namazov.keme.converter;

import ru.namazov.keme.dto.UserDto;
import ru.namazov.keme.dto.UserNewDto;
import ru.namazov.keme.entity.User;

public interface UserDtoConverter {

    User toEntity(UserNewDto userNewDto);

    UserDto toDto(User user);
}
