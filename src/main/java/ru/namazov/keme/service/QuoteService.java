package ru.namazov.keme.service;

import java.util.List;
import java.util.Optional;

import ru.namazov.keme.entity.Quote;

public interface QuoteService {

    Quote create(Quote quote);

    Quote getRandom();

    void delete(Long quote);

    Quote update(Quote quote, Long id);

    List<Quote> getTop(Long topCount, Boolean whichTop);

    Optional<Quote> findById(long quoteId);

    void decrementVotesNumber(Quote quote, boolean isPositive);

    void incrementVotesNumber(Quote quote, boolean isPositive);
}
