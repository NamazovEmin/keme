package ru.namazov.keme.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.namazov.keme.converter.UserDtoConverter;
import ru.namazov.keme.dto.UserDto;
import ru.namazov.keme.dto.UserNewDto;
import ru.namazov.keme.entity.User;
import ru.namazov.keme.repository.UserRepository;
import ru.namazov.keme.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserDtoConverter userDtoConverter;
    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserNewDto userNewDto) {
        User user = userDtoConverter.toEntity(userNewDto);
        User savedUser = userService.create(user);
        UserDto savedUserDto = userDtoConverter.toDto(savedUser);
        return  ResponseEntity.ok().body(savedUserDto);
    }
}
