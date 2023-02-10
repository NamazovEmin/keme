/*
 * Copyright (c) 2023, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package ru.namazov.keme.repository.facade;

import org.springframework.stereotype.Repository;

import ru.namazov.keme.entity.Vote;
import ru.namazov.keme.repository.VoteRepository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class VoteFacadeRepositoryImpl implements VoteFacadeRepository {

    VoteRepository voteRepository;

    @Override
    public Vote save(Vote vote) {
        return voteRepository.save(vote);
    }
}
