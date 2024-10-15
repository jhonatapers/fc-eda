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
@Table(name = "accounts")
@Entity
public class AccountModel {

    @Id
    private String id;

    private BigDecimal balance;

    public AccountModel(String id) {
        this.id = id;
    }

}
