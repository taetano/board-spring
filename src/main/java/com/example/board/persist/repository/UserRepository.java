package com.example.board.persist.repository;

import com.example.board.persist.User;
import com.example.board.persist.repository.base.BaseHibernateRepository;
import com.example.board.persist.repository.base.BaseJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseJpaRepository<User, Long>, BaseHibernateRepository<User> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
