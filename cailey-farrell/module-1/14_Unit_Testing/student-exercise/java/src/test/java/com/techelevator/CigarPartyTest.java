package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CigarPartyTest {

    private CigarParty subject;
   // int number1 = 30;
    //int number2 = 50;
    //int number3 = 70;


    @Before
    public void setUp() throws Exception {
        subject = new CigarParty();
    }

    @Test
    public void havePartyIfLessThanFortyCigarsAndWeekend() {
            Boolean actual = subject.haveParty(30, true);
            assertEquals(false,actual);
        }
    @Test
    public void havePartyIfLessThanFortyCigarsAndWeekday() {
        Boolean actual = subject.haveParty(30, false);
        assertEquals(false,actual);
    }
    @Test
    public void havePartyIfInRangeCigarsAndWeekend() {
        Boolean actual = subject.haveParty(40, true);
        assertEquals(true,actual);
    }
    @Test
    public void havePartyIfInRangeCigarsAndWeekday() {
        Boolean actual = subject.haveParty(40, true);
        assertEquals(true,actual);
    }
    @Test
    public void havePartyIfMoreThanSixtyCigarsAndWeekday() {
        Boolean actual = subject.haveParty(61, false);
        assertEquals(false,actual);
    }
    @Test
    public void havePartyIfMoreThanSixtyCigarsAndWeekend() {
        Boolean actual = subject.haveParty(61, true);
        assertEquals(true, actual);
    }

}