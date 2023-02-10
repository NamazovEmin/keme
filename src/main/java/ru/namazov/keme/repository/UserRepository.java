package ru.namazov.keme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.namazov.keme.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
