package ru.namazov.keme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.namazov.keme.entity.VotingEvent;

public interface VotingEventRepository extends JpaRepository<VotingEvent, Long> {
}
