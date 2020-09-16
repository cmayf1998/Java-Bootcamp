package com.techelevator.entity;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TellerMachineTest {

    private  TellerMachine subject;

    @Before
    public void setup(){
        subject = new TellerMachine(
                "Moe's LTD",
                new BigDecimal(750),
                new BigDecimal(400));
    }

    @Test
    public void isValidCardNumber5with16() {
        assertTrue(subject.isValidCardNumber("5999999999999999"));
    }

    @Test
    public void isValidCardNumber4with16() {
        assertTrue(subject.isValidCardNumber("4999999999999999"));
    }

    @Test
    public void isValidCardNumber4with14() {
        assertTrue(subject.isValidCardNumber("49999999999999"));
    }

    @Test
    public void getBalance() {
        assertEquals(new BigDecimal(350), subject.getBalance());
    }
}