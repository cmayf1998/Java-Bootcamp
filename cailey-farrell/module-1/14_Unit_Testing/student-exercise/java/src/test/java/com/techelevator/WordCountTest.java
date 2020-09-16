package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class WordCountTest {
    private WordCount subject;

    @Before
    public void setUp() throws Exception {
        subject = new WordCount();
    }

    @Test
    public void getCount() {
        String[] actual = new String[]{"ba", "ba", "black", "sheep"};
        Map<String, Integer> map = new HashMap<>();
        map.put("ba", 2);
        map.put("black", 1);
        map.put("sheep", 1);
        assertEquals(map, subject.getCount(actual));
    }
}