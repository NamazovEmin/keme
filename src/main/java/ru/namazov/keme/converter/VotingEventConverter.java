package ru.namazov.keme.converter;

import java.util.List;

import ru.namazov.keme.dto.VotingEventDto;
import ru.namazov.keme.entity.VotingEvent;

public interface VotingEventConverter {

    VotingEventDto toDto(VotingEvent votingEvent);

    List<VotingEventDto> toVotingEventDtoList(List<VotingEvent> votingEventList);
}
