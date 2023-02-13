package ru.namazov.keme.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ru.namazov.keme.entity.Quote;
import ru.namazov.keme.repository.QuoteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuoteService {

    private final QuoteRepository quoteRepository;

    public Quote save(Quote quote) {
        return quoteRepository.save(quote);
    }

    public Quote get(long id) {
        return quoteRepository.findById(id).orElseThrow(() -> new RuntimeException("sds"));
    }

//    public List<Quote> getTop10() {
//        return quoteRepository.findFirst10ByOrderByCountPositiveVoteDesc();
//    }
//
//    public List<Quote> getWorst10() {
//        return quoteRepository.findFirst10ByOrderByCountNegativeVoteDesc();
//    }

    public Quote getRandom() {
        Quote quote = quoteRepository.findTopByOrderByIdDesc();
        long random = ThreadLocalRandom.current().nextInt(1, (int) (quote.getId() + 1));
        return quoteRepository.findById(random).orElseThrow(() -> new RuntimeException("sds"));
    }

    public void delete(Long quote) {
        quoteRepository.deleteById(quote);
    }

    public Quote put(Quote quote, Long id) {
        Quote dbQuote = quoteRepository.findById(id).orElseThrow(() -> new RuntimeException("sds"));
        dbQuote.setText(quote.getText());
        return quoteRepository.save(dbQuote);
    }

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
