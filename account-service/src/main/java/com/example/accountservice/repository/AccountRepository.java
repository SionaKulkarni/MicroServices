package com.example.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.accountservice.model.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findById(Long id); 
}
