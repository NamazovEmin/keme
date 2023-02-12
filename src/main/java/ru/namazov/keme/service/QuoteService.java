package ru.namazov.keme.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
        Quote quote = quoteRepository.getReferenceById(id);
        return quote;
    }

    public List<Quote> getTop10() {
        Page<Quote> page = quoteRepository.findAll(PageRequest.of(0, 10, Sort.by(Sort.Order.desc("countPositiveVote"))));
        return page.getContent();
    }

    public void delete(Quote quote) {
        quoteRepository.delete(quote);
    }
}
