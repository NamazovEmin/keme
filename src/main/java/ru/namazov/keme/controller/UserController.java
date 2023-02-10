package ru.namazov.keme.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.namazov.keme.converter.UserDtoConverter;
import ru.namazov.keme.dto.UserDto;
import ru.namazov.keme.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserDtoConverter userDtoConverter;
    private final UserService userService;

    @PostMapping
    public UserDto create(@RequestBody UserDto userDto) {
        return  userDtoConverter.toDto(userService.create(userDtoConverter.fromDto(userDto)));
    }
}
