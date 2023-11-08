package com.example.board.persist.repository;

import com.example.board.persist.User;
import com.example.board.persist.repository.base.BaseHibernateRepository;
import com.example.board.persist.repository.base.BaseHibernateRepositoryImpl;
import com.example.board.type.ProviderType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    User user;

    @BeforeEach
    public void setup() {
        user = User.builder()
                .name("test1")
                .email("email")
                .password("password")
                .nickname("nickname")
                .phone("010-1234-1234")
                .provider(ProviderType.OWN)
                .phoneAuthYN(true)
                .build();
        userRepository.persist(user);
    }

    @Test
    @DisplayName("이메일과 일치하는 유저 찾기")
    public void findByEmail() {
    // given

    // when
        User dbUser = userRepository.findByEmail(user.getEmail()).get();

    // then
        assertThat(dbUser).isNotNull();
    }

    @Test
    @DisplayName("이메일이 존재하는지 확인")
    public void existsByEmail() {
    // given

    // when
        boolean exists = userRepository.existsById(1L);

        // then
        assertThat(exists).isTrue();
    }

}