package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalGroupNameTest {

    private AnimalGroupName subject;

    @Before
    public void setUp() throws Exception {
        subject = new AnimalGroupName();
    }

    @Test
    public void getHerdCaseInsensitive() {
        String actual = subject.getHerd("RHINO");
        assertEquals("Crash", actual);
    }

    @Test
    public void getHerdIfNull() {
        String actual = subject.getHerd("null");
        assertEquals("unknown", actual);
    }

    @Test
    public void getHerdIfEmpty() {
        String actual = subject.getHerd("");
        assertEquals("unknown", actual);
    }

    @Test
    public void getHerdNotInList() {
        String actual = subject.getHerd("walrus");
        assertEquals("unknown", actual);
    }

}

