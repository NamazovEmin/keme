package ru.namazov.keme.converter;

import org.springframework.stereotype.Component;

import ru.namazov.keme.dto.VoteDto;
import ru.namazov.keme.entity.Vote;

@Component
public class VoteDtoConverter {

    public Vote fromDto(VoteDto voteDto) {
        return new Vote(
                voteDto.getUser(),
                voteDto.getQuote(),
                voteDto.isPositive()
        );
    }

    public VoteDto toDto(Vote vote) {
        return new VoteDto(
                vote.getId(),
                vote.getUser(),
                vote.getQuote(),
                vote.isPositive(),
                vote.getCreateDate()
        );
    }
}
