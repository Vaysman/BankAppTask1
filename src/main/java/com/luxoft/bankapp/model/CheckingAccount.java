package com.luxoft.bankapp.model;

public class CheckingAccount extends AbstractAccount {
    private float overdraft;

    public CheckingAccount(float balance) {
        this(balance, 0);
    }

    public CheckingAccount(float initialBalance, float overdraft) {
        super(initialBalance);
        this.overdraft = overdraft;
    }

    @Override
    public String getReport() {
        return "Checking Account balance: " + balance + ", overdraft: " + overdraft;
    }

    @Override
    public void withdraw(float amount) {
        if(balance + overdraft >= amount) {
            balance -= amount;
        }
    }
}
