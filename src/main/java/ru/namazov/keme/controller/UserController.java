package ru.namazov.keme.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.namazov.keme.converter.UserDtoConverter;
import ru.namazov.keme.dto.UserDto;
import ru.namazov.keme.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserDtoConverter userDtoConverter;
    private final UserService userService;

    @PostMapping
    public UserDto create(UserDto userDto){
       return  userDtoConverter.toDto(userService.save(userDtoConverter.fromDto(userDto)));
    }
}
