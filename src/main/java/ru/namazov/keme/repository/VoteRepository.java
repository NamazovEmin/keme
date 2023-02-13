package ru.namazov.keme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.namazov.keme.entity.Quote;
import ru.namazov.keme.entity.User;
import ru.namazov.keme.entity.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    List<Vote> findByUserAndQuote(User user, Quote quote);
}
