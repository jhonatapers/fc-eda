package com.jhonatapers.accounts.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AccountModel {

    @Id
    private String accountId;

    private BigDecimal balance;

    public AccountModel(String accountId) {
        this.accountId = accountId;
    }

}
