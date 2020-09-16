package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TellerMachineTest {

    private TellerMachine subject;

    @Before
    public void setup(){
        subject = new TellerMachine( new TellerMachine("Acme Machines",
                new BigDecimal( 1000.00), new BigDecimal(300.00));
            }

    @Test
    public void isValidCardNumber5With16() {
        assertTrue(subject.isValidCardNumber("59999999999999999999"));
    }


    @Test
    public void getBalance(){
            TellerMachine subject = new TellerMachine("Acme Machines", new BigDecimal( 1000.00), new BigDecimal(300.00));
            assertEquals(new BigDecimal(350), subject.getBalance());
        }
    }