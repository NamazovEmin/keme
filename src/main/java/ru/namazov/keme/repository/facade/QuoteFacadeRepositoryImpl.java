/*
 * Copyright (c) 2023, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package ru.namazov.keme.repository.facade;

import org.springframework.stereotype.Repository;

import ru.namazov.keme.entity.Quote;
import ru.namazov.keme.repository.QuoteRepository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class QuoteFacadeRepositoryImpl implements QuoteFacadeRepository {

    private final QuoteRepository quoteRepository;

    @Override
    public Quote save(Quote quote) {
        return quoteRepository.save(quote);
    }

    @Override
    public Quote get(long id) {
        return quoteRepository.getReferenceById(id);
    }

    @Override
    public void delete(Quote quote) {
        quoteRepository.delete(quote);
    }

}
