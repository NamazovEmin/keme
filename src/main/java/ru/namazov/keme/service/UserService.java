package ru.namazov.keme.service;

import java.util.Optional;

import ru.namazov.keme.entity.User;

public interface UserService {

    User create(User user);

    Optional<User> findById(long userId);
}
