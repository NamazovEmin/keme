package ru.namazov.keme.service;

import org.springframework.stereotype.Service;

import ru.namazov.keme.entity.Vote;
import ru.namazov.keme.repository.VoteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VoteService {

    VoteRepository voteRepository;

    public Vote save(Vote vote) {
        return voteRepository.save(vote);
    }
}
