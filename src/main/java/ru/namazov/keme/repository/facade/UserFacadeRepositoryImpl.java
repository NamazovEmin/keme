/*
 * Copyright (c) 2023, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package ru.namazov.keme.repository.facade;

import org.springframework.stereotype.Repository;

import ru.namazov.keme.entity.User;
import ru.namazov.keme.repository.UserReposytory;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class UserFacadeRepositoryImpl implements UserFacadeRepository {

    private final UserReposytory userReposytory;

    @Override
    public User save(User user) {
        return userReposytory.save(user);
    }
}
