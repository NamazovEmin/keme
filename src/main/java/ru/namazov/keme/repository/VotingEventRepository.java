package ru.namazov.keme.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.namazov.keme.entity.VotingEvent;

public interface VotingEventRepository extends JpaRepository<VotingEvent, Long> {

    Optional<List<VotingEvent>> findAllByQuoteIdOrderByCreateDateAsc(Long id);
}
