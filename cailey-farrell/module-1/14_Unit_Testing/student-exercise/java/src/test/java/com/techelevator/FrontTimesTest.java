package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrontTimesTest {
    private FrontTimes subject;

    @Before
    public void setUp() throws Exception {
        subject = new FrontTimes();
    }

    @Test
    public void generateStringIfTwice() {
        String actual = subject.generateString("Chocolate",2);
        assertEquals("ChoCho", actual);
    }
    @Test
    public void generateStringIfThreeTimes() {
        String actual = subject.generateString("Chocolate",3);
        assertEquals("ChoChoCho", actual);
    }

    @Test
    public void generateStringIfWordIsOnlyThreeLetters() {
        String actual = subject.generateString("Abc",3);
        assertEquals("AbcAbcAbc", actual);
    }

    public void generateStringIfWordIsLessThanThreeLetters() {
        String actual = subject.generateString("Hi",3);
        assertEquals("HiHiHi", actual);
    }

}