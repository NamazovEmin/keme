package ru.namazov.keme.service;

import org.springframework.stereotype.Service;

import ru.namazov.keme.entity.Quote;
import ru.namazov.keme.repository.QuoteFacadeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuoteService {

    private final QuoteFacadeRepository quoteFacadeRepository;

    public Quote save(Quote quote) {
        return quoteFacadeRepository.save(quote);
    }
}
