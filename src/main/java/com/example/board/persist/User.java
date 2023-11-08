package com.example.board.persist;

import com.example.board.type.ProviderType;
import com.example.board.type.Role;
import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.time.LocalDateTime;

@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, length = 40)
    private String email;

    @JsonIgnore
    @Column(length = 72)
    private String password;

    @Column(unique = true, length = 10)
    private String nickname;

    @Column(unique = true, length = 13)
    private String phone;

    @Column
    @Enumerated(EnumType.STRING)
    private ProviderType provider;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean emailAuthYN;
    private boolean phoneAuthYN;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    @Builder
    public User(String name, String email, String password, String nickname, String phone, ProviderType provider, boolean phoneAuthYN) {
        assert phoneAuthYN : "핸드폰 인증 오류";
        this.name = name;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.phone = phone;
        this.provider = provider;
        this.role = Role.ROLE_USER;
        this.phoneAuthYN = true;
        this.createdAt = LocalDateTime.now();
    }

    @Builder(builderMethodName = "admin")
    public User(String name, String email, String password, String nickname, String phone, Role role, boolean phoneAuthYN) {
        assert phoneAuthYN : "핸드폰 인증 오류";
        this.name = name;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.phone = phone;
        this.provider = ProviderType.OWN;
        this.role = role;
        this.phoneAuthYN = true;
        this.createdAt = LocalDateTime.now();
    }

    public void authEmail() {
        this.emailAuthYN = true;
    }
}
