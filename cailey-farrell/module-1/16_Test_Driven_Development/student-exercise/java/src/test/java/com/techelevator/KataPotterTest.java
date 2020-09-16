package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KataPotterTest{

    private KataPotter subject;

    int priceIf1 = 8;
    double priceIf2 = 15.2;
    double priceIf3 = 21.6;
    double priceIf4 = 25.6;
    double priceIf5 = 30;


    @Before
    public void setUp() throws Exception {
        subject = new KataPotter();
    }

    @Test
    public void costOfEachSetIndividually(){
      int[] setOfOne = new int[]{1};
      assertEquals(priceIf1, subject.getCost(setOfOne));
    }
    @Test
    public void purchase2DifferentBooks(){
        KataPotter total = new KataPotter();
        int[] books = {1,2,0,0,0};
        assertEquals(priceIf2 + 8, total.getCost(books),.01);
    }

    @Test
    public void purchase3Books(){
        KataPotter total = new KataPotter();
        int[] books = {1,1,1,0,0};
        assertEquals(priceIf3, total.getCost(books),.01);
    }

    @Test
    public void purchase4Books(){
        KataPotter total = new KataPotter();
        int[] books = {1,1,1,1,0};
        assertEquals(priceIf4, total.getCost(books),.01);
    }
    @Test
    public void purchase5Books(){
        KataPotter total = new KataPotter();
        int[] books = {2,2,2,1,1};
        assertEquals(priceIf5, total.getCost(books),.01);
    }


}