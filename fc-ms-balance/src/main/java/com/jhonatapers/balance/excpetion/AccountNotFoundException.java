package com.jhonatapers.balance.excpetion;

import com.jhonatapers.balance.model.AccountModel;

public class AccountNotFoundException extends ResourceNotFoundException {

    private AccountNotFoundException(String id) {
        super(AccountModel.class, id);
    }

    public static AccountNotFoundException withId(String id) {
        return new AccountNotFoundException(id);
    }

}
