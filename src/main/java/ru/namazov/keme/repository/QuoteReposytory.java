package ru.namazov.keme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.namazov.keme.entity.Quote;

public interface QuoteReposytory extends JpaRepository<Quote, Long> {
}
