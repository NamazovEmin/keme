package ru.namazov.keme.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.namazov.keme.converter.UserDtoConverterImpl;
import ru.namazov.keme.dto.UserDto;
import ru.namazov.keme.dto.UserNewDto;
import ru.namazov.keme.entity.User;
import ru.namazov.keme.service.UserServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserDtoConverterImpl userDtoConverterImpl;
    private final UserServiceImpl userServiceImpl;

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserNewDto userNewDto) {
        User user = userDtoConverterImpl.toEntity(userNewDto);
        User savedUser = userServiceImpl.create(user);
        UserDto savedUserDto = userDtoConverterImpl.toDto(savedUser);
        return  ResponseEntity.ok().body(savedUserDto);
    }
}
