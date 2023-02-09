package ru.namazov.keme.repository;

import ru.namazov.keme.entity.Quote;

public interface QuoteFacadeRepository {

    Quote save(Quote quote);
    Quote get(long id);
    void delete(Quote quote);
}
