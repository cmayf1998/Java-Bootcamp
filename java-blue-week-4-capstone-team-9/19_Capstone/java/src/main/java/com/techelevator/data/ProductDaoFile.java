package com.techelevator.data;

import com.techelevator.*;
import com.techelevator.entity.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static com.techelevator.data.Logger.*;

public class ProductDaoFile {

    public static Map<String, Product> loadProductData(String productsFile, String delimeter) {
        Map<String, Product> productMap = new LinkedHashMap<>();

        try {
            Scanner reader = new Scanner(new File(productsFile));

            while (reader.hasNext()) {
                String currentLine = reader.nextLine();
                String[] tokens = currentLine.split(delimeter);
                if (tokens[3].equals("Chip")){
                    Chip chip = new Chip(tokens[0], tokens[1], new BigDecimal(tokens[2]), 5);
                    productMap.put(chip.getSlotLocation(), chip);
                }
                if (tokens[3].equals("Candy")){
                    Candy candy = new Candy(tokens[0], tokens[1], new BigDecimal(tokens[2]), 5);
                    productMap.put(candy.getSlotLocation(), candy);
                }
                if (tokens[3].equals("Gum")){
                    Gum gum = new Gum(tokens[0], tokens[1], new BigDecimal(tokens[2]), 5);
                    productMap.put(gum.getSlotLocation(), gum);
                }
                if (tokens[3].equals("Drink")){
                    Drink drink = new Drink(tokens[0], tokens[1], new BigDecimal(tokens[2]), 5);
                    productMap.put(drink.getSlotLocation(), drink);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
        return productMap;

    }


}







