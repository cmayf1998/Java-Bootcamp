package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CustomerTest {

    Customer subject = new Customer();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void feedMoneyIsWholeDollarAmountTest() {
        BigDecimal userInput = new BigDecimal("1.00");
        assertTrue(subject.feedMoney(userInput));
    }

    @Test
    public void feedMoneyIsNotWholeDollarAmountTest() {
        BigDecimal userInput = new BigDecimal("5.99");
        assertFalse(subject.feedMoney(userInput));
    }

    @Test
    public void purchaseItem() {
    }

    @Test
    public void getMessage() {
        BigDecimal userInput = new BigDecimal("5.00");
        subject.feedMoney(userInput);
        assertEquals("Current Money Provided: 5.00",subject.getWallet());
    }
}