package com.luxoft.bankapp.model;

import com.luxoft.bankapp.model.Account;

public class SavingAccount extends AbstractAccount {
    public SavingAccount(float initialBalance) {
        super(initialBalance);
    }

    @Override
    public String getReport() {
        return "Saving Account: " + balance;
    }
}
