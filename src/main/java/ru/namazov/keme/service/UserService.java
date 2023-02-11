package ru.namazov.keme.service;

import org.springframework.stereotype.Service;

import ru.namazov.keme.entity.User;
import ru.namazov.keme.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }
}
