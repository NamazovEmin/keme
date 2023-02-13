package ru.namazov.keme.service;

import ru.namazov.keme.entity.Vote;

public interface VoteService {

    Vote create(Vote vote);

    Vote findById(Long id);

    void deleteById(Long id);
}
