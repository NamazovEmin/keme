package ru.namazov.keme.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ru.namazov.keme.entity.User;
import ru.namazov.keme.exceptions.ResourceAlreadyExistsResponseException;
import ru.namazov.keme.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        if (userAlreadyExists(user.getEmail())) {
            throw new ResourceAlreadyExistsResponseException(String.format("User with email:%s already exists", user.getEmail()));
        }
        return userRepository.save(user);

    }

    @Override
    public Optional<User> findById(long userId) {
        return userRepository.findById(userId);
    }

    private boolean userAlreadyExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
