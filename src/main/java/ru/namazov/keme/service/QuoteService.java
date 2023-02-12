package ru.namazov.keme.service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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

    public List<Quote> getTop10() {
        return quoteRepository.findFirst10ByOrderByCountPositiveVoteDesc();
    }

    public List<Quote> getWorst10() {
        return quoteRepository.findFirst10ByOrderByCountNegativeVoteDesc();
    }

    public Quote getRandom() {
        Quote quote = quoteRepository.findTopByOrderByIdDesc();
        long random = ThreadLocalRandom.current().nextInt(1, (int) (quote.getId() + 1));
        return quoteRepository.findById(random).orElseThrow(() -> new RuntimeException("sds"));
    }

    public void delete(Quote quote) {
        quoteRepository.delete(quote);
    }
}
