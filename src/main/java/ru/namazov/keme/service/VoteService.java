package ru.namazov.keme.service;

import org.springframework.stereotype.Service;

import ru.namazov.keme.entity.Vote;
import ru.namazov.keme.repository.facade.VoteFacadeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VoteService {

    VoteFacadeRepository voteFacadeRepository;

    public Vote save(Vote vote) {
        return voteFacadeRepository.save(vote);
    }
}
