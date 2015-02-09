package com.luxoft.bankapp.service;

import com.luxoft.bankapp.model.Account;
import com.luxoft.bankapp.model.Bank;
import com.luxoft.bankapp.model.Client;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BankServiceImplTest {
    @Mock
    Bank bank;

    @Mock
    Client client;

    @Mock
    Account account;

    BankService bankService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bankService = new BankServiceImpl();
    }

    @Test
    public void testSetActiveAccount() throws Exception {
        bankService.setActiveAccount(client, account);

        verify(client).setActiveAccount(account);
    }

    @Test
    public void testAddAccount() throws Exception {
        bankService.addAccount(client, account);

        verify(client).addAccount(account);
    }

    @Test
    public void testRemoveClient() throws Exception {
        bankService.removeClient(bank, client);

        verify(bank).removeClient(client);
    }

    @Test
    public void testAddClient() throws Exception {
        bankService.addClient(bank, client);

        verify(bank).addClient(client);
    }
}