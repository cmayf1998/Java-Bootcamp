package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringBitsTest {
    private StringBits subject;

    @Before
    public void setUp() throws Exception {
        subject = new StringBits();
    }

    @Test
    public void getBitsHello() {
        String actual = subject.getBits("Hello");
        assertEquals("Hlo", actual);
    }
    @Test
    public void getBitsHi() {
        String actual = subject.getBits("Hi");
        assertEquals("H", actual);
    }
    @Test
    public void getBitsHeeololeo() {
        String actual = subject.getBits("Heeololeo");
        assertEquals("Hello", actual);
    }
    @Test
    public void getIfNull() {
        String actual = subject.getBits("");
        assertEquals("", actual);
    }
}
