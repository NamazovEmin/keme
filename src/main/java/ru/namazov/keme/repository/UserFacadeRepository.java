package ru.namazov.keme.repository;

import ru.namazov.keme.entity.User;

public interface UserFacadeRepository {
    User save(User user);
}
