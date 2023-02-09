package ru.namazov.keme.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.namazov.keme.converter.UserDtoConverter;
import ru.namazov.keme.dto.UserDto;
import ru.namazov.keme.entity.User;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
@AllArgsConstructor
public class UserController {

    private final UserDtoConverter userDtoConverter;

    @PostMapping
    public void createUser(UserDto userDto){
        User user = userDtoConverter.fromDto(userDto);

    }
}
