package com.jhonatapers.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonatapers.accounts.model.AccountModel;

public interface AccountRepository extends JpaRepository<AccountModel, String> {

}
