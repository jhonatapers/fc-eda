package com.jhonatapers.balance.usecase;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.jhonatapers.balance.excpetion.AccountNotFoundException;
import com.jhonatapers.balance.service.AccountService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class GetAccountBalanceUC {

    private final AccountService accountService;

    public BigDecimal run(GetAccountBalanceUC.Input input) {

        return accountService
                .findAccountById(input.accountId)
                .orElseThrow(() -> AccountNotFoundException.withId(input.accountId))
                .getBalance();

    }

    public record Input(String accountId) {
    }

}
