package com.techelevator;

import com.sun.xml.internal.fastinfoset.algorithm.IntEncodingAlgorithm;
import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataFizzBuzzTest {

    private KataFizzBuzz subject;

    @Before
    public void setUp() throws Exception {
        subject = new KataFizzBuzz();
    }

    @Test
    public void numberIsDivisibleBy3And5PrintOutFizzBuzz(){
        assertEquals("Number is Divisible by 3 and 5 ", "FizzBuzz",subject.fizzBuzz(15));
    }

    @Test
    public void numberIs3PrintOutFizz(){
        assertEquals("Add passing code for test method","Fizz",subject.fizzBuzz(3));
    }

    @Test
    public void numberContains3PrintOutFizz(){
        assertEquals("Add passing code for test method" ,"Fizz",subject.fizzBuzz(3));
    }

    @Test
    public void numberIs5PrintOutBuzz(){
        assertEquals("Add passing code for test method","Buzz", subject.fizzBuzz(5));
    }

    @Test
    public void numberIfEmpty(){
        assertEquals("Add passing code for test method","",subject.fizzBuzz(0));
    }

    @Test
    public void numberIfNotDivisibleBy3Or5(){
        assertEquals("Add passing code for test method","1",subject.fizzBuzz(1));
    }

    @Test
    public void numberIfContains3(){
        assertEquals("Add passing code for test method","Fizz",subject.fizzBuzz(13));
    }

    @Test
    public void numberIfContains5(){
        assertEquals("Add passing code for test method","Buzz",subject.fizzBuzz(58));
    }

    @Test
    public void numberIfContains3And5(){
        assertEquals("Add passing code for test method","FizzBuzz",subject.fizzBuzz(53));
    }

    @Test
    public void numberIsLessThan0OrGreaterThan100(){
        assertEquals("Add passing code for test method","",subject.fizzBuzz(150));
    }

    @Test
    public void numberIsBetween0And100ButDoesNotMeetRequirements(){
        assertEquals("Add passing code for test method","4",subject.fizzBuzz(4));
    }
}
