package ru.namazov.keme.service;

import org.springframework.stereotype.Service;

import ru.namazov.keme.entity.User;
import ru.namazov.keme.repository.UserFacadeRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
    private final UserFacadeRepository userFacadeRepository;

    public User save(User user) {
        return userFacadeRepository.save(user);
    }
}
