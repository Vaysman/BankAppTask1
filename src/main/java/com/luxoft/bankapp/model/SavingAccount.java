package com.luxoft.bankapp.model;

import com.luxoft.bankapp.model.Account;

public class SavingAccount implements Account {
    private float balance;

    public SavingAccount(float initialBalance) {
        balance = initialBalance;
    }

    @Override
    public void deposit(float amount) {
        balance += amount;
    }

    @Override
    public float getBalance() {
        return balance;
    }

    @Override
    public void withdraw(float amount) {
        if (balance >= amount) {
            balance -= amount;
        }
    }

    @Override
    public String getReport() {
        return "Saving Account: " + balance;
    }
}
