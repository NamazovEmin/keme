package ru.namazov.keme.converter;

import org.springframework.stereotype.Component;

import ru.namazov.keme.dto.VoteDto;
import ru.namazov.keme.entity.Vote;

@Component
public class VoteDtoConverter {

    public Vote toEntity(VoteDto voteDto) {
        return new Vote(
                voteDto.getUserId(),
                voteDto.getQuoteId(),
                voteDto.isPositive()
        );
    }

    public VoteDto toDto(Vote vote) {
        return new VoteDto(
                vote.getId(),
                vote.getUserId(),
                vote.getQuoteId(),
                vote.isPositive(),
                vote.getCreateDate()
        );
    }
}
