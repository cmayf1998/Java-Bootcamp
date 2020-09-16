package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lucky13Test {

    private Lucky13 subject;
    int[] number1 = {0,2,4};
    int[] number2 = {1,2,3};
    int[] number3 = {1,2,4};

    @Before
    public void setUp() throws Exception {
        subject = new Lucky13();
    }

    @Test
    public void getLuckyIfNo1sAnd3s() {
        Boolean actual = subject.getLucky(number1);
        assertEquals(true, actual);
    }

    @Test
    public void getLuckyIfBoth() {
        Boolean actual = subject.getLucky(number2);
        assertEquals(false, actual);
    }
    @Test
    public void getLuckyIf1OrA3() {
        Boolean actual = subject.getLucky(number3);
        assertEquals(false, actual);
    }
}