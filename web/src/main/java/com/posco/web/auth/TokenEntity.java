package com.posco.web.auth;

import com.posco.web.common.BaseEntity;
import com.posco.web.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@Table(name="tokens")
@NoArgsConstructor
@AllArgsConstructor
public class TokenEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", insertable = false, updatable = false, length = 10)
    private String userId;

    @Column(name="refresh_token", nullable = false)
    private String refreshToken;

    @OneToOne(targetEntity = UserEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

}
