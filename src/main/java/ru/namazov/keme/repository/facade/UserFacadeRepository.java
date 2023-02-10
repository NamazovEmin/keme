/*
 * Copyright (c) 2023, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package ru.namazov.keme.repository.facade;

import ru.namazov.keme.entity.User;

public interface UserFacadeRepository {
    User save(User user);
}
