package com.luxoft.bankapp.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class CheckingAccountTest {
    public static final float ONE_EURO = 1.0f;
    public static final float TWO_EURO = 2.0f;
    public static final float ERROR_DELTA = 0.00001f;

    @Test
    public void testGetReport() throws Exception {
        Account account = new CheckingAccount(ONE_EURO, TWO_EURO);

        assertThat(account.getReport(), allOf(containsString("Checking"), containsString("1.0"), containsString("2.0")));
    }

    @Test
    public void testWithdraw() throws Exception {
        Account account = new CheckingAccount(ONE_EURO, TWO_EURO);

        account.withdraw(TWO_EURO);

        assertEquals(-1.0f, account.getBalance(), ERROR_DELTA);
    }

}