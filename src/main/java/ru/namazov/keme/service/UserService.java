package ru.namazov.keme.service;

import ru.namazov.keme.entity.User;
import ru.namazov.keme.repository.UserFacadeRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserService {
    private final UserFacadeRepository userFacadeRepository;

    public User save(User user) {
        return userFacadeRepository.save(user);
    }
}
