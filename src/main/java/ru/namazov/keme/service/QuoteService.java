/*
 * Copyright (c) 2023, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package ru.namazov.keme.service;

import java.util.List;
import java.util.Optional;

import ru.namazov.keme.entity.Quote;

public interface QuoteService {

    Quote save(Quote quote);

    Quote getRandom();

    void delete(Long quote);

    Quote put(Quote quote, Long id);

    List<Quote> getTop(Long topCount, Boolean whichTop);

    Optional<Quote> findById(long quoteId);
}
