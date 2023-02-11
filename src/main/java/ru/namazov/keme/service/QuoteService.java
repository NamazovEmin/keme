package ru.namazov.keme.service;

import java.util.Collections;
import java.util.List;

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
        return quoteRepository.getReferenceById(id);
    }
    public List<Quote> getTop10() {
        return Collections.emptyList();
    }

    public void delete(Quote quote) {
        quoteRepository.delete(quote);
    }
}
