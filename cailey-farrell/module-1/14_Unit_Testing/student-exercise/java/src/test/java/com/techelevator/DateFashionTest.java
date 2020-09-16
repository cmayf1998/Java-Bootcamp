package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateFashionTest {

    private DateFashion subject;

    @Before
    public void setUp() throws Exception {
        subject = new DateFashion();
    }

    @Test
    public void getATableIfEitherStylish() {
        int actual = subject.getATable(5,10);
        assertEquals(2, actual);
    }

    @Test
    public void getATableIfOneLessThanTwo() {
        int actual = subject.getATable(5,2);
        assertEquals(0, actual);
    }

    @Test
    public void getATableIfNeitherStylishOrUnstylish() {
        int actual = subject.getATable(5,5);
        assertEquals(1, actual);
    }
}