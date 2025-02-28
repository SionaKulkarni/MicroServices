package com.example.webservice.controller;

import com.example.webservice.model.Account;
import com.example.webservice.service.AccountServiceClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webservice/accounts")
public class WebServiceController {
    private final AccountServiceClient accountServiceClient;

    public WebServiceController(AccountServiceClient accountServiceClient) {
        this.accountServiceClient = accountServiceClient;
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable("id") Long id) {  
    	return accountServiceClient.getAccountById(id);
    }


    @GetMapping
    public List<Account> getAllAccounts() {
        return accountServiceClient.getAllAccounts();
    }
}
