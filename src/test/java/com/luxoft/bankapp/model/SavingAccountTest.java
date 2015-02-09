package com.luxoft.bankapp.model;

import com.luxoft.bankapp.model.Account;
import com.luxoft.bankapp.model.SavingAccount;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SavingAccountTest {
    public static final float ONE_EURO = 1.0f;

    @Test
    public void testGetReport() throws Exception {
        Account account = new SavingAccount(ONE_EURO);

        assertThat(account.getReport(), allOf(containsString("Saving"), containsString("1.0")));
    }
}