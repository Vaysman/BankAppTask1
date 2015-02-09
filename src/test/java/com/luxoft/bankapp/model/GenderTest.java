package com.luxoft.bankapp.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GenderTest {
    @Test
    public void getPrefixMaleTest() throws Exception {
        assertThat(Gender.MALE.getPrefix(), is("Mr."));
    }

    @Test
    public void getPrefixFemaleTest() throws Exception {
        assertThat(Gender.FEMALE.getPrefix(), is("Ms."));
    }
}