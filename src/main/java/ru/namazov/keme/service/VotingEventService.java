package ru.namazov.keme.service;

import java.util.List;

import ru.namazov.keme.entity.VotingEvent;

public interface VotingEventService {

    void save(VotingEvent votingEvent);

    List<VotingEvent> getDiagram(long id);
}
