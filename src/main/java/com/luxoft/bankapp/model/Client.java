package com.luxoft.bankapp.model;

import com.luxoft.bankapp.model.Account;

import java.util.ArrayList;
import java.util.List;

public class Client implements Report {

    private List<Account> accounts;
    private Account activeAccount;
    private String name;

    public Client(String name) {
        accounts = new ArrayList<>();
        this.name = name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Account getActiveAccount() {
        return activeAccount;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("Client: ").append(name).append(System.lineSeparator());
        for (Account account : accounts) {
            report.append(account.getReport()).append(System.lineSeparator());
        }
        return report.toString();
    }

    public void setActiveAccount(Account account) {
        if (!accounts.contains(account)) {
            addAccount(account);
        }

        activeAccount = account;
    }
}
