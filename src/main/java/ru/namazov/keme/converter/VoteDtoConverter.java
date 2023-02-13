package ru.namazov.keme.converter;

import ru.namazov.keme.dto.VoteDto;
import ru.namazov.keme.dto.VoteNewDto;
import ru.namazov.keme.entity.Vote;

public interface VoteDtoConverter {

    Vote toEntity(VoteNewDto voteNewDto);

    VoteDto toDto(Vote vote);
}
