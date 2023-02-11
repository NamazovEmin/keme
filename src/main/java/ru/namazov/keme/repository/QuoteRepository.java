package ru.namazov.keme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.namazov.keme.entity.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
