package com.jhonatapers.balance.event.handler;

import org.springframework.stereotype.Component;

import com.jhonatapers.balance.event.AccountBalanceUpdatedEvent;
import com.jhonatapers.balance.usecase.UpdateAccountBalanceUC;

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