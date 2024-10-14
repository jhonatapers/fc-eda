package com.jhonatapers.accounts.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jhonatapers.accounts.model.AccountModel;
import com.jhonatapers.accounts.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public Optional<AccountModel> findAccountById(String accountId) {
        return accountRepository.findById(accountId);
    }

    public void updateAccountBalance(AccountModel account, BigDecimal balance) {
        account.setBalance(balance);
        accountRepository.save(account);
    }

}
