package ru.namazov.keme.service;

import org.springframework.stereotype.Service;

import ru.namazov.keme.entity.VotingEvent;
import ru.namazov.keme.repository.VotingEventRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VotingEventService {

    private final VotingEventRepository votingEventRepository;

    public void save(VotingEvent votingEvent) {
        votingEventRepository.save(votingEvent);
    }
}
