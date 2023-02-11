package ru.namazov.keme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.namazov.keme.entity.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
}
