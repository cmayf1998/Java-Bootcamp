package com.techelevator.biz;

import com.techelevator.entity.Customer;
import com.techelevator.entity.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class TransactionManagerTest {

    private TransactionManager subject;

    @Before
    public void setUp() throws Exception {
        subject = new TransactionManager();
    }

    @Test
    public void mapNotNullTest(){
      assertTrue("Map should not be null", subject.getTransactions() != null);
      assertTrue("Map passed in should not be null",
              new TransactionManager(null).getTransactions() != null);
    }

    @Test
    public void addTransactionTest(){
        Customer cust1 = new Customer("Deon", "deon@myco.com", LocalDate.now());
        Transaction trans1 = new Transaction(LocalDate.now(), new BigDecimal(100), "Trans1");
        assertTrue("Transaction should add successfully", subject.add(cust1, trans1));

    }
}