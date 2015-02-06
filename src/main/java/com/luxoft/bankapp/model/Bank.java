package com.luxoft.bankapp.model;

import java.util.ArrayList;
import java.util.List;

public class Bank implements Report {

    private List<Client> clients;

    public Bank() {
        clients = new ArrayList<>();
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public List<Client> getClients() {
        return clients;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("Bank report").append(System.lineSeparator());
        for (Client client : clients) {
            report.append(client.getReport()).append(System.lineSeparator());
        }
        return report.toString();
    }
}
