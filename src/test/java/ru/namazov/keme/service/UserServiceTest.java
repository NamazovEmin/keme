package ru.namazov.keme.service;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ru.namazov.keme.entity.User;
import ru.namazov.keme.repository.facade.UserFacadeRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserFacadeRepository userFacadeRepository;
    private UserService userService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userFacadeRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        User user = new User("121", "1212", "1212");
        User userSaved = new User(1,"121", "1212", "1212", new Date());
        when(userFacadeRepository.save(user)).thenReturn(userSaved);
        assertEquals(userSaved,userService.create(user));
    }
}