package ru.namazov.keme.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import ru.namazov.keme.dto.VotingEventDto;
import ru.namazov.keme.entity.VotingEvent;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class VotingEventConverter {

    public VotingEventDto toDto(VotingEvent votingEvent) {
        return new VotingEventDto(
                votingEvent.getId(),
                votingEvent.getQuoteId(),
                votingEvent.getVoteId(),
                votingEvent.getEventType(),
                votingEvent.getCountLikeAtThisTime(),
                votingEvent.getCountDisLikeAtThisTime(),
                votingEvent.getCreateDate()
        );
    }

    public List<VotingEventDto> toVotingEventDtoList(List<VotingEvent> votingEventList) {
        return votingEventList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
