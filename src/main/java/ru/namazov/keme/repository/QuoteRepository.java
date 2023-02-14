package ru.namazov.keme.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.namazov.keme.entity.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    Optional<Quote> findTopByOrderByIdDesc();
}
