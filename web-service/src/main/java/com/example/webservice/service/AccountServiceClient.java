package com.example.webservice.service;

import com.example.webservice.model.Account;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;

@Service
public class AccountServiceClient {
    private final WebClient.Builder webClientBuilder;
    
    @Value("${account.service.url}")
    private String accountServiceUrl;

    public AccountServiceClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Account getAccountById(Long id) {
        return webClientBuilder.build()
                .get()
                .uri(accountServiceUrl + "/" + id)
                .retrieve()
                .bodyToMono(Account.class)
                .block();
    }

    public List<Account> getAllAccounts() {
        return webClientBuilder.build()
                .get()
                .uri(accountServiceUrl)
                .retrieve()
                .bodyToFlux(Account.class)
                .collectList()
                .block();
    }
}
