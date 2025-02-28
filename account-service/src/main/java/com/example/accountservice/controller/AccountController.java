package com.example.accountservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.accountservice.model.Account;
import com.example.accountservice.service.AccountService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        System.out.println("Received Account: " + account.getName() + ", " + account.getEmail()); // Debugging
        return service.saveAccount(account);
    }


    @GetMapping
    public List<Account> getAllAccounts() {
        return service.getAllAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") Long id) {
        Optional<Account> account = service.getAccountById(id);
        return account.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable("id") Long id) { 
        if (service.deleteAccount(id)) {
            return ResponseEntity.ok("Account deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
}
