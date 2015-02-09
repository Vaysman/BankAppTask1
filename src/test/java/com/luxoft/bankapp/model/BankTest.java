package com.luxoft.bankapp.model;

import com.luxoft.bankapp.model.Bank;
import com.luxoft.bankapp.model.Client;
import com.luxoft.bankapp.model.Report;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BankTest {
    public static final String NAME = "name";

    @Test
    public void addClientTest() throws Exception {
        Bank bank = new Bank();
        Client client = new Client(NAME);
        bank.addClient(client);

        List<Client> clients = bank.getClients();

        assertThat(clients.size(), is(1));
        assertThat(clients, hasItem(client));
    }

    @Test
    public void removeClientTest() throws Exception {
        Bank bank = new Bank();
        Client client = new Client(NAME);
        bank.addClient(client);

        bank.removeClient(client);
        List<Client> clients = bank.getClients();

        assertThat(clients.size(), is(0));
        assertThat(clients, not(hasItem(client)));
    }

    @Test
    public void getClientsTest() throws Exception {
        Bank bank = new Bank();

        List<Client> clients = bank.getClients();

        assertThat(clients, is(notNullValue()));
    }

    @Test
    public void getReportCallsGetReportFromClientTest() throws Exception {
        Bank bank = new Bank();
        Client client = mock(Client.class);
        bank.addClient(client);

        bank.getReport();

        verify(client).getReport();
    }

    @Test
    public void getReportTest() throws Exception {
        Bank bank = new Bank();

        Client client = new Client(NAME);
        bank.addClient(client);

        assertThat(bank.getReport(), containsString(NAME));
    }

    @Test
    public void shouldImplementsReport() throws Exception {
        Bank bank = new Bank();

        assertThat(bank, instanceOf(Report.class));
    }
}