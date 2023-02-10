/*
 * Copyright (c) 2023, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package ru.namazov.keme.repository.facade;

import ru.namazov.keme.entity.Vote;

public interface VoteFacadeRepository {

    Vote save(Vote vote);
}
