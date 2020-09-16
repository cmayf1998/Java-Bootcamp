package com.techelevator;

import com.techelevator.biz.TransactionManager;
import com.techelevator.console.Client;
import com.techelevator.data.CustomerDao;
import com.techelevator.data.CustomerDaoFile;
import com.techelevator.data.TransactionDao;
import com.techelevator.data.TransactionDaoFile;
import com.techelevator.entity.*;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {



//        try (PrintWriter pw = new PrintWriter(new File("demo.txt"));) {
//            pw.println("This is our demo file!");
//
//        } catch (FileNotFoundException ex){
//            System.out.println("Error: " + ex.getMessage());
//            ex.printStackTrace(System.out);
//            System.exit(1);
//        }

//        try {
//            BufferedReader out = new BufferedReader( new FileReader("customerData.csv") );
//            String line = null;
//            while ((line = out.readLine()) != null){
//                System.out.println(line);
//            }
//        }
//        // stack catch blocks with subclasses before super classes
//        catch (FileNotFoundException ex) {
//            System.out.println("Error: " + ex.getMessage());
//            ex.printStackTrace(System.out);
//            System.exit(1);
//        }
//        catch (IOException ex) {
//            System.out.println("Error: " + ex.getMessage());
//            ex.printStackTrace(System.out);
//            System.exit(1);
//        }

        // use "try with resources" for AutoCloseable classes!!!!!!!
//        try (Scanner scanner = new Scanner( new File("customerData.csv") );
//              ) {
//            while (scanner.hasNext()){
//                System.out.println(scanner.nextLine());
//            }
//        }
//        // stack catch blocks with subclasses before super classes
//        catch (FileNotFoundException ex) {
//            System.out.println("Error: " + ex.getMessage());
//            ex.printStackTrace(System.out);
//            System.exit(1);
//        }

        CustomerDao customerDao = null;
        TransactionManager manager = null;
        try {
            customerDao = new CustomerDaoFile("customerData.csv", ",");

            manager = new TransactionManager(customerDao, new TransactionDaoFile());

        } catch (Exception ex){
            // Do something useful here!
            System.out.println("Error: " + ex.getMessage());
            System.exit(1);
        }
        Client client = new Client(manager, customerDao);
        client.startClient();
    }
}
