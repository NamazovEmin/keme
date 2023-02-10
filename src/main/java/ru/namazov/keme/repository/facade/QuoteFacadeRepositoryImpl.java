/*
 * Copyright (c) 2023, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package ru.namazov.keme.repository.facade;

import org.springframework.stereotype.Repository;

import ru.namazov.keme.entity.Quote;
import ru.namazov.keme.repository.QuoteReposytory;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class QuoteFacadeRepositoryImpl implements QuoteFacadeRepository {

    private final QuoteReposytory quoteReposytory;

    @Override
    public Quote save(Quote quote) {
        return quoteReposytory.save(quote);
    }

    @Override
    public Quote get(long id) {
        return quoteReposytory.getReferenceById(id);
    }

    @Override
    public void delete(Quote quote) {
        quoteReposytory.delete(quote);
    }

}
