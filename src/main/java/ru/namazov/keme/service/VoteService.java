package ru.namazov.keme.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.namazov.keme.entity.Vote;
import ru.namazov.keme.entity.VotingEvent;
import ru.namazov.keme.enums.VoteEventType;
import ru.namazov.keme.repository.VoteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;
    private final QuoteService quoteService;
    private final VotingEventService votingEventService;

    @Transactional
    public Vote create(Vote vote) {
        quoteService.incrementVotesNumber(vote.getQuote(), vote.isPositive());
        VotingEvent votingEvent;
        if (vote.isPositive()){
            votingEvent = new VotingEvent(vote.getQuote().getId(), VoteEventType.LIKE,vote.getQuote().getCountPositiveVotes(),
                    vote.getQuote().getCountNegativeVotes());
        } else {
            votingEvent = new VotingEvent(vote.getQuote().getId(), VoteEventType.DISLIKE,vote.getQuote().getCountPositiveVotes(),
                    vote.getQuote().getCountNegativeVotes());
        }
        votingEventService.save(votingEvent);
        return voteRepository.save(vote);
    }

    public Vote findById(Long id) {
        return voteRepository.findById(id).orElseThrow(() -> new RuntimeException("sds"));
    }

    public void deleteById(Long id) {
        Vote vote = findById(id);
        quoteService.decrementVotesNumber(vote.getQuote(), vote.isPositive());
        VotingEvent votingEvent;
        if (vote.isPositive()){
            votingEvent = new VotingEvent(vote.getQuote().getId(), VoteEventType.TAKE_LIKE_BACK,vote.getQuote().getCountPositiveVotes(),
                    vote.getQuote().getCountNegativeVotes());
        } else {
            votingEvent = new VotingEvent(vote.getQuote().getId(), VoteEventType.TAKE_DISLiKE_BACK,vote.getQuote().getCountPositiveVotes(),
                    vote.getQuote().getCountNegativeVotes());
        }
        votingEventService.save(votingEvent);
        voteRepository.deleteById(id);
    }
}
