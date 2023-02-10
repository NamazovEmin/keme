/*
 * Copyright (c) 2023, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package ru.namazov.keme.repository.facade;

import org.springframework.stereotype.Repository;

import ru.namazov.keme.entity.User;
import ru.namazov.keme.repository.UserRepository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class UserFacadeRepositoryImpl implements UserFacadeRepository {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
