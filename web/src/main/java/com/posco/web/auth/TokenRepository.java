package com.posco.web.auth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository <TokenEntity, Long> {
}
