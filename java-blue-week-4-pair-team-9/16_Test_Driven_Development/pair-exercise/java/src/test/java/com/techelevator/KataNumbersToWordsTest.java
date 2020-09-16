package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataNumbersToWordsTest {

    private KataNumbersToWords subject;


    @Before
    public void setUp() throws Exception {
        subject = new KataNumbersToWords();
    }

    @Test
    public void ifStringIsEmpty(){
        assertEquals(0, subject.add(""));
    }

    @Test
    public void ifStringIsMultiple(){
        assertEquals(3, subject.add("1,2"));
    }

    @Test
    public void ifStringIs1(){
        assertEquals(1, subject.add("1"));
    }


    @Test
    public void ifStringIsOutsideList(){
        assertEquals(24, subject.add("5,7,12"));
    }


}
