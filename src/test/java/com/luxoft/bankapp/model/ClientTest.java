package com.luxoft.bankapp.model;

import com.luxoft.bankapp.model.Account;
import com.luxoft.bankapp.model.Client;
import com.luxoft.bankapp.model.Report;
import com.luxoft.bankapp.model.SavingAccount;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ClientTest {

    public static final String NAME = "name";

    @Test
    public void addAccountsTest() throws Exception {
        Client client = new Client(NAME);
        Account account = new SavingAccount(0.0f);
        client.addAccount(account);

        List<Account> accounts = client.getAccounts();

        assertThat(accounts.size(), is(1));
        assertThat(accounts, hasItem(account));
    }

    @Test
    public void setGetActiveAccountsTest() throws Exception {
        Client client = new Client(NAME);
        Account account = new SavingAccount(0.0f);
        client.addAccount(account);

        client.setActiveAccount(account);
        Account actual = client.getActiveAccount();

        assertThat(account, is(actual));
    }


    @Test
    public void getAccountsTest() throws Exception {
        Client client = new Client(NAME);

        List<Account> accounts = client.getAccounts();

        assertThat(accounts, is(notNullValue()));
    }

    @Test
    public void getNameTest() throws Exception {
        Client client = new Client(NAME);

        assertThat(client.getName(), is(NAME));
    }

    @Test
    public void getReportCallsGetReportFromAccountTest() throws Exception {
        Client client = new Client(NAME);
        Account account = mock(Account.class);
        client.addAccount(account);

        client.getReport();

        verify(account).getReport();
    }

    @Test
    public void getReportTest() throws Exception {
        Client client = new Client(NAME);
        Account account = new SavingAccount(1.0f);

        client.addAccount(account);

        assertThat(client.getReport(), allOf(containsString(NAME), containsString("Saving"), containsString("1.0")));
    }

    @Test
    public void shouldImplementsReport() throws Exception {
        Client client = new Client(NAME);

        assertThat(client, instanceOf(Report.class));
    }
}