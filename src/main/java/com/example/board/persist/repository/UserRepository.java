package com.example.board.persist.repository;

import com.example.board.persist.User;
import com.example.board.persist.repository.base.BaseHibernateRepository;
import com.example.board.persist.repository.base.BaseJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseJpaRepository<User, Long>, BaseHibernateRepository<User> {
}
