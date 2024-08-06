package com.saran.applicationdev.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saran.applicationdev.model.Token;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JwtRepo extends JpaRepository<Token, String> {

    List<Token> findAllByUser_UidAndExpiredFalseAndRevokedFalse(Long uid);

    Optional<Token> findByToken(String token);
}
