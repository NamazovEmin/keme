package ru.namazov.keme.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.namazov.keme.entity.Quote;
import ru.namazov.keme.exceptions.ResourceNotFoundResponseException;
import ru.namazov.keme.repository.QuoteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;

    @Override
    public Quote create(Quote quote) {
        return quoteRepository.save(quote);
    }

    @Override
    @Transactional
    public Quote getRandom() {
        Optional<Quote> quote = quoteRepository.findTopByOrderByIdDesc();
        if (quote.isEmpty()) {
            throw new ResourceNotFoundResponseException("No Quotes saved");
        }

        long random = ThreadLocalRandom.current().nextLong(1, quote.get().getId() + 1);

        if ((quoteRepository.findById(random).isPresent())) {
            return quoteRepository.findById(random).orElseThrow(() -> new ResourceNotFoundResponseException("Quote is missing"));
        } else {
            getRandom();
        }
        return null;
    }

    @Override
    public void delete(Long quote) {
        quoteRepository.deleteById(quote);
    }

    @Override
    @Transactional
    public Quote update(Quote quote, Long id) {
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
