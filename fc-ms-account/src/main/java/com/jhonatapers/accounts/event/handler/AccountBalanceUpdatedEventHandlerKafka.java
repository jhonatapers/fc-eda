package com.jhonatapers.accounts.event.handler;

import org.springframework.stereotype.Component;

import com.jhonatapers.accounts.event.AccountBalanceUpdatedEvent;
import com.jhonatapers.accounts.usecase.UpdateAccountBalanceUC;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AccountBalanceUpdatedEventHandlerKafka {

    private final UpdateAccountBalanceUC updateAccountBalanceUc;

    @Transactional
    public void handle(AccountBalanceUpdatedEvent event) {

        updateAccountBalanceUc.run(
                new UpdateAccountBalanceUC.Input(
                        event.payload().account_id_from(),
                        event.payload().balanceAccountIDFrom()));

        updateAccountBalanceUc.run(
                new UpdateAccountBalanceUC.Input(
                        event.payload().accountIDTo(),
                        event.payload().balanceAccountIDTo()));
    }

}