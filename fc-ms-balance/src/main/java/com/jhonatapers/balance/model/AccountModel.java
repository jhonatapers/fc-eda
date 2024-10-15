package com.jhonatapers.balance.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(schema = "wallet", name = "accounts")
@Entity
public class AccountModel {

    @Id
    private String accountId;

    private BigDecimal balance;

    public AccountModel(String accountId) {
        this.accountId = accountId;
    }

}
