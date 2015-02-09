package com.luxoft.bankapp.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class AbstractAccountTest {
    public static final float ERROR_DELTA = 0.00001f;
    public static final float ONE_EURO = 1.0f;
    public static final float TWO_EURO = 2.0f;
    public static final float ZERO_EURO = 0.0f;

    class TestingAbstractAccount extends AbstractAccount {
        public TestingAbstractAccount(float balance) {
            super(balance);
        }

        // will not to be tested
        @Override
        public String getReport() {
            return null;
        }
    }

    @Test
    public void shouldImplementsAccount() throws Exception {
        Account account = new TestingAbstractAccount(ONE_EURO);

        assertThat(account, instanceOf(Account.class));
    }

    @Test
    public void testDeposit() throws Exception {
        Account account = new TestingAbstractAccount(ZERO_EURO);

        account.deposit(ONE_EURO);
        assertEquals(account.getBalance(), ONE_EURO, ERROR_DELTA);
    }

    @Test
    public void testGetBalance() throws Exception {
        Account account = new TestingAbstractAccount(ONE_EURO);

        assertEquals(account.getBalance(), ONE_EURO, ERROR_DELTA);
    }

    @Test
    public void testWithdraw() throws Exception {
        Account account = new TestingAbstractAccount(ONE_EURO);

        account.withdraw(ONE_EURO);

        assertEquals(account.getBalance(), ZERO_EURO, ERROR_DELTA);
    }

    @Test
    public void testWithdrawWithAmountGreaterThanBalance() throws Exception {
        Account account = new TestingAbstractAccount(ONE_EURO);

        account.withdraw(TWO_EURO);

        assertEquals(account.getBalance(), ONE_EURO, ERROR_DELTA);
    }


}