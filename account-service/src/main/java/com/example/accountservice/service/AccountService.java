package com.example.accountservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.accountservice.model.Account;
import com.example.accountservice.repository.AccountRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository repository;
    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        System.out.println("Fetching account with ID: " + id); // Debugging
        return repository.findById(id);
    }


    public Account saveAccount(Account account) {
        return repository.save(account);
    }

    public boolean deleteAccount(Long id) {
        if (repository.existsById(id)) { 
            repository.deleteById(id);  
            return true;                
        }
        return false; 
    }
}
