package ru.namazov.keme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.namazov.keme.entity.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
    Quote findTopByOrderByIdDesc();
//    List<Quote> findFirst10ByOrderByCountPositiveVoteDesc();
//    List<Quote> findFirst10ByOrderByCountNegativeVoteDesc();
}
