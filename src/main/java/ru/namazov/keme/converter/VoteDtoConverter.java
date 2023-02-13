package ru.namazov.keme.converter;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ru.namazov.keme.dto.VoteDto;
import ru.namazov.keme.dto.VoteNewDto;
import ru.namazov.keme.entity.Quote;
import ru.namazov.keme.entity.User;
import ru.namazov.keme.entity.Vote;
import ru.namazov.keme.service.QuoteService;
import ru.namazov.keme.service.UserService;
import ru.namazov.keme.service.VotingEventService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class VoteDtoConverter {

    private final UserService userService;
//    private final QuoteRepository quoteRepository;
    private final QuoteService quoteService;
    private final VotingEventService votingEventService;

    @Transactional
    public Vote toEntity(VoteNewDto voteNewDto) {
//        доделать эксепшены
        User user = userService.findById(voteNewDto.getUserId()).orElseThrow(() -> new RuntimeException("sds"));
        Quote quote = quoteService.findById(voteNewDto.getQuoteId()).orElseThrow(() -> new RuntimeException("sds"));
        return new Vote(
                user,
                quote,
                voteNewDto.isPositive()
        );

    }

    public VoteDto toDto(Vote vote) {
        return new VoteDto(
                vote.getId(),
                vote.getUser().getId(),
                vote.getQuote().getId(),
                vote.isPositive(),
                vote.getCreateDate()
        );
    }
}
