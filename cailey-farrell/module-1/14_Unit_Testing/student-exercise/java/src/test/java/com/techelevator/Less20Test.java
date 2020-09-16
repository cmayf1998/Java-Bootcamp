package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Less20Test {

    private Less20 subject;

    @Before
    public void setUp() throws Exception {
        subject = new Less20();
    }

    @Test
    public void isLessThanMultipleOf20by2() {
        Boolean actual = subject.isLessThanMultipleOf20(18);
        assertEquals(true,actual);
    }
    @Test
    public void isLessThanMultipleOf20by1() {
        Boolean actual = subject.isLessThanMultipleOf20(19);
        assertEquals(true,actual);
    }

    @Test
    public void isAMultipleOf20() {
        Boolean actual = subject.isLessThanMultipleOf20(20);
        assertEquals(false,actual);
    }

    @Test
    public void isMoreThanMultipleOf20by1() {
        Boolean actual = subject.isLessThanMultipleOf20(21);
        assertEquals(false,actual);
    }

}