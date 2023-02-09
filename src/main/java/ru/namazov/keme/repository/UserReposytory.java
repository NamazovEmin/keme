
package ru.namazov.keme.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import ru.namazov.keme.entity.User;

public interface UserReposytory extends JpaRepository<User, Long> {
}
