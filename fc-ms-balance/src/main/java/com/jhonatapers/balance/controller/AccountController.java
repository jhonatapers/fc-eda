package com.jhonatapers.balance.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jhonatapers.balance.usecase.GetAccountBalanceUC;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class AccountController {

    private final GetAccountBalanceUC getAccoutnBalanceUC;

    @GetMapping("balances/{account_id}")
    public ResponseEntity<BigDecimal> getMethodName(@PathVariable("account_id") String account_id) {
        return ResponseEntity.ok(getAccoutnBalanceUC.run(new GetAccountBalanceUC.Input(account_id)));
    }

}
