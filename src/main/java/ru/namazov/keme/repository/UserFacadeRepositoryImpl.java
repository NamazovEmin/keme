package ru.namazov.keme.repository;

import org.springframework.stereotype.Repository;

import ru.namazov.keme.entity.User;

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
