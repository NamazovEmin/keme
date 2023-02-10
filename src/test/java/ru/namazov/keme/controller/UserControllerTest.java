package ru.namazov.keme.controller;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ru.namazov.keme.converter.UserDtoConverter;
import ru.namazov.keme.dto.UserDto;
import ru.namazov.keme.entity.User;
import ru.namazov.keme.service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


class UserControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private UserDtoConverter userDtoConverter;

    private UserController userController;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userController = new UserController(userDtoConverter,userService);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void create() {
        UserDto userDto = new UserDto("bob", "sdsd", "sd@gmail.com");
        User user = new User("bob", "dsds", "sd@gmail.com");
        User userSaved = new User(1L,"bob", "dsds", "sd@gmail.com",new Date());
        UserDto userDtoSaved = new UserDto(1L,"bob", "dsds", "sd@gmail.com");
        when(userDtoConverter.fromDto(userDto)).thenReturn(user) ;
        when(userService.create(user)).thenReturn(userSaved);
        when(userDtoConverter.toDto(userSaved)).thenReturn(userDtoSaved);
        userController.create(userDto);
        assertEquals(userDtoSaved,userController.create(userDto));
    }
}