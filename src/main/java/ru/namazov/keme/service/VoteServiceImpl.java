package ru.namazov.keme.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.namazov.keme.entity.Vote;
import ru.namazov.keme.entity.VotingEvent;
import ru.namazov.keme.enums.VoteEventType;
import ru.namazov.keme.exceptions.ResourceAlreadyExistsResponseException;
import ru.namazov.keme.exceptions.ResourceNotFoundResponseException;
import ru.namazov.keme.repository.VoteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;
    private final QuoteServiceImpl quoteServiceImpl;
    private final VotingEventServiceImpl votingEventServiceImpl;

    @Transactional
    @Override
    public Vote create(Vote vote) {
        if (voteAlreadyExists(vote)) {
            throw new ResourceAlreadyExistsResponseException(String.format("Vote with userId:%d and quoteId:%d already exists",
                    vote.getUser().getId(), vote.getQuote().getId()));
        }
        quoteServiceImpl.incrementVotesNumber(vote.getQuote(), vote.isPositive());
        VotingEvent votingEvent;
        if (vote.isPositive()){
            votingEvent = new VotingEvent(vote.getQuote().getId(), VoteEventType.LIKE,vote.getQuote().getCountPositiveVotes(),
                    vote.getQuote().getCountNegativeVotes());
        } else {
            votingEvent = new VotingEvent(vote.getQuote().getId(), VoteEventType.DISLIKE,vote.getQuote().getCountPositiveVotes(),
                    vote.getQuote().getCountNegativeVotes());
        }
        votingEventServiceImpl.save(votingEvent);
        return voteRepository.save(vote);
    }

    @Override
    public Vote findById(Long id) {
        return voteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundResponseException(String.format("Vote with id: %d not found", id)));
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Vote vote = findById(id);
        quoteServiceImpl.decrementVotesNumber(vote.getQuote(), vote.isPositive());
        VotingEvent votingEvent;
        if (vote.isPositive()){
            votingEvent = new VotingEvent(vote.getQuote().getId(), VoteEventType.TAKE_LIKE_BACK,vote.getQuote().getCountPositiveVotes(),
                    vote.getQuote().getCountNegativeVotes());
        } else {
            votingEvent = new VotingEvent(vote.getQuote().getId(), VoteEventType.TAKE_DISLiKE_BACK,vote.getQuote().getCountPositiveVotes(),
                    vote.getQuote().getCountNegativeVotes());
        }
        votingEventServiceImpl.save(votingEvent);
        voteRepository.delete(vote);
    }

    private boolean voteAlreadyExists(Vote vote) {
        return !voteRepository.findByUserAndQuote(vote.getUser(), vote.getQuote()).isEmpty();
    }

}
