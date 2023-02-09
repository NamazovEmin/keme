package ru.namazov.keme.repository;

import org.springframework.stereotype.Repository;

import ru.namazov.keme.entity.Quote;

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
