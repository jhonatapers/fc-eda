package com.jhonatapers.balance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonatapers.balance.model.AccountModel;

public interface AccountRepository extends JpaRepository<AccountModel, String> {

}
