package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NonStartTest {
    private NonStart subject;

    @Before
    public void setUp() throws Exception {
        subject = new NonStart();
    }

    @Test
    public void getPartialStringHelloThere() {
        String actual = subject.getPartialString("Hello", "There");
        assertEquals("ellohere", actual);
    }

    @Test
    public void getPartialStringJavaCode() {
        String actual = subject.getPartialString("java", "code");
        assertEquals("avaode", actual);
    }

    @Test
    public void getPartialStringShotlJava() {
        String actual = subject.getPartialString("shotl", "java");
        assertEquals("hotlava", actual);
    }
}

