package ru.namazov.keme.converter;

import org.springframework.stereotype.Component;

import ru.namazov.keme.dto.VoteDto;
import ru.namazov.keme.dto.VoteNewDto;
import ru.namazov.keme.entity.Quote;
import ru.namazov.keme.entity.User;
import ru.namazov.keme.entity.Vote;
import ru.namazov.keme.repository.QuoteRepository;
import ru.namazov.keme.repository.UserRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class VoteDtoConverter {

    private final UserRepository userRepository;
    private final QuoteRepository quoteRepository;

    public Vote toEntity(VoteNewDto voteNewDto) {
//        доделать эксепшены
        User user = userRepository.findById(voteNewDto.getUserId()).orElseThrow(() -> new RuntimeException("sds"));
        Quote quote = quoteRepository.findById(voteNewDto.getQuoteId()).orElseThrow(() -> new RuntimeException("sds"));
        if (voteNewDto.isPositive()){
            quote.setCountPositiveVote(quote.getCountPositiveVote() + 1L);
        } else {
            quote.setCountNegativeVote(quote.getCountNegativeVote() + 1L);
        }
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
