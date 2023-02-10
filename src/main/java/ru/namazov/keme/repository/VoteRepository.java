package ru.namazov.keme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.namazov.keme.entity.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
