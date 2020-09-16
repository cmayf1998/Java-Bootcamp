package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Same;

import static org.junit.Assert.*;

public class SameFirstLastTest {

    private SameFirstLast subject;
    int[] number1 = {0,1,0};
    int[] number2 = {1,2,3,1};
    int[] number3 = {4,5,6};
    int[] number4 = {};

    @Before
    public void setUp() throws Exception {
        subject = new SameFirstLast();
    }

    @Test
    public void isItTheSameLength() {
        Boolean actual = subject.isItTheSame(number1);
        assertEquals(true,actual);
    }

    @Test
    public void isItTheSameLengthAndGreaterThanThree() {
        Boolean actual = subject.isItTheSame(number2);
        assertEquals(true,actual);
    }

    @Test
    public void isItTheNotSameLength() {
        Boolean actual = subject.isItTheSame(number3);
        assertEquals(false,actual);
    }

    @Test
    public void isItEmpty() {
        Boolean actual = subject.isItTheSame(number4);
        assertEquals(false,actual);
    }
}