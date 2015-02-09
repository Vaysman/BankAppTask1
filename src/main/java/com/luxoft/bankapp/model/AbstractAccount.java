package com.luxoft.bankapp.model;

public abstract class AbstractAccount implements Account {
    protected float balance;

    public AbstractAccount(float balance) {
        this.balance = balance;
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
}

