package ru.namazov.keme.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ru.namazov.keme.entity.Quote;
import ru.namazov.keme.exceptions.ResourceNotFoundResponseException;
import ru.namazov.keme.repository.QuoteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;

    @Override
    public Quote save(Quote quote) {
        return quoteRepository.save(quote);
    }

    @Override
    public Quote getRandom() {
        Quote quote = quoteRepository.findTopByOrderByIdDesc();
        long random = ThreadLocalRandom.current().nextInt(1, (int) (quote.getId() + 1));
        return quoteRepository.findById(random).orElseThrow(() -> new ResourceNotFoundResponseException("Quote is missing"));
    }

    @Override
    public void delete(Long quote) {
        quoteRepository.deleteById(quote);
    }

    @Override
    public Quote put(Quote quote, Long id) {
        Quote dbQuote = quoteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundResponseException(String.format("Quote with id: %d not found", id)));
        dbQuote.setText(quote.getText());
        return quoteRepository.save(dbQuote);
    }

    @Override
    public List<Quote> getTop(Long topCount, Boolean whichTop) {
        Page<Quote> page;
        if (whichTop) {
            page = quoteRepository.findAll(
                    PageRequest.of(0, Math.toIntExact(topCount), Sort.by(Sort.Order.desc("countNegativeVotes"))));
        } else {
            page = quoteRepository.findAll(
                    PageRequest.of(0, Math.toIntExact(topCount), Sort.by(Sort.Order.desc("countNegativeVotes"))));
        }
        return page.getContent();
    }

    @Override
    public Optional<Quote> findById(long quoteId) {
        return quoteRepository.findById(quoteId);
    }

    public void incrementVotesNumber(Quote quote, boolean isPositive) {
        if (isPositive){
            quote.setCountPositiveVotes(quote.getCountPositiveVotes() + 1L);
        } else {
            quote.setCountNegativeVotes(quote.getCountNegativeVotes() + 1L);
        }
    }

    public void decrementVotesNumber(Quote quote, boolean isPositive) {
        if (isPositive){
            quote.setCountPositiveVotes(quote.getCountPositiveVotes() - 1L);
        } else {
            quote.setCountNegativeVotes(quote.getCountNegativeVotes() - 1L);
        }
    }
}
