package com.luxoft.bankapp.model;

import com.luxoft.bankapp.model.Account;
import com.luxoft.bankapp.model.SavingAccount;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SavingAccountTest {

    public static final float ERROR_DELTA = 0.00001f;
    public static final float ONE_EURO = 1.0f;
    public static final float TWO_EURO = 2.0f;
    public static final float ZERO_EURO = 0.0f;

    @Test
    public void shouldImplementsAccount() throws Exception {
        SavingAccount account = new SavingAccount(ONE_EURO);

        assertThat(account, instanceOf(Account.class));
    }

    @Test
    public void testDeposit() throws Exception {
        Account account = new SavingAccount(ZERO_EURO);

        account.deposit(ONE_EURO);
        assertEquals(account.getBalance(), ONE_EURO, ERROR_DELTA);
    }

    @Test
    public void testGetBalance() throws Exception {
        Account account = new SavingAccount(ONE_EURO);

        assertEquals(account.getBalance(), ONE_EURO, ERROR_DELTA);
    }

    @Test
    public void testGetReport() throws Exception {
        Account account = new SavingAccount(ONE_EURO);

        assertThat(account.getReport(), allOf(containsString("Saving"), containsString("1.0")));
    }

    @Test
    public void testWithdraw() throws Exception {
        Account account = new SavingAccount(ONE_EURO);

        account.withdraw(ONE_EURO);

        assertEquals(account.getBalance(), ZERO_EURO, ERROR_DELTA);
    }

    @Test
    public void testWithdrawWithAmountGreaterThanBalance() throws Exception {
        Account account = new SavingAccount(ONE_EURO);

        account.withdraw(TWO_EURO);

        assertEquals(account.getBalance(), ONE_EURO, ERROR_DELTA);
    }

}