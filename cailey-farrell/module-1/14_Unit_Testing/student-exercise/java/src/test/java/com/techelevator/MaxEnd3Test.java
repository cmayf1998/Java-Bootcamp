package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxEnd3Test {

    private MaxEnd3 subject;
    int[] number1 = {1, 2, 3};
    int[] number2 = {11, 5, 9};
    int[] number3 = {2, 11, 3};
    int[] number4 = {3, 3, 3};
    int[] number5 = {11, 11, 11};


    @Before
    public void setUp() throws Exception {
        subject = new MaxEnd3();
    }

    @Test
    public void makeArrayLastOneHighest() {
        int[] actual = subject.makeArray(number1);
        assertEquals(number4, actual);
    }

    @Test
    public void makeArrayFirstOneHighest() {
        int[] actual = subject.makeArray(number2);
        assertEquals(number5, actual);
    }

    @Test
    public void makeArray() {
        int[] actual = subject.makeArray(number3);
        assertEquals(number4, actual);
    }
}