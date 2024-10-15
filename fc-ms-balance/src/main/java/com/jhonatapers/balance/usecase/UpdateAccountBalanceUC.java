package com.jhonatapers.balance.usecase;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.jhonatapers.balance.model.AccountModel;
import com.jhonatapers.balance.service.AccountService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UpdateAccountBalanceUC {

    private final AccountService accountService;

    public void run(UpdateAccountBalanceUC.Input input) {
        accountService
                .findAccountById(input.accountId)
                .ifPresentOrElse(account -> {
                    accountService.updateAccountBalance(account, input.balance);
                }, () -> {
                    accountService.updateAccountBalance(new AccountModel(input.accountId), input.balance);
                });
    }

    public record Input(String accountId, BigDecimal balance) {
    }

}
