package ru.namazov.keme.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ru.namazov.keme.entity.VotingEvent;
import ru.namazov.keme.exceptions.ResourceNotFoundResponseException;
import ru.namazov.keme.repository.VotingEventRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VotingEventService {

    private final VotingEventRepository votingEventRepository;

    public void save(VotingEvent votingEvent) {
        votingEventRepository.save(votingEvent);
    }

    public List<VotingEvent> getDiagram(long id) {
        return votingEventRepository.findAllByQuoteIdOrderByCreateDateAsc(id).orElseThrow(() -> new ResourceNotFoundResponseException("No history"));
    }
}
