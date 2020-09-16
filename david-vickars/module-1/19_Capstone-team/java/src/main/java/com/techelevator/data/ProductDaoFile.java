package com.techelevator.data;

import com.techelevator.entity.*;
import com.techelevator.exceptions.DataAccessException;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductDaoFile implements ProductDao {
    @Override
    public Map<String, Product> getProducts() throws DataAccessException {
        return getProducts("vendingmachine.csv", "\\|");
    }

    @Override
    public Map<String, Product> getProducts(String connectionString, String delimiter)
        throws DataAccessException {
        Map<String, Product> productMap = new LinkedHashMap<>();
        try (Scanner scanner = new Scanner( new File(connectionString) )) {
            while (scanner.hasNextLine()) {
                Product currentProduct = null;
                String[] tokens = scanner.nextLine().split(delimiter);
                String productType = tokens[3];
                if (productType.equals("Chip")) { // code, name, price
                    currentProduct = new Chip(tokens[0], tokens[1], new BigDecimal(tokens[2]));
                } else if (productType.equals("Candy")) { // code, name, price
                    currentProduct = new Candy(tokens[0], tokens[1], new BigDecimal(tokens[2]));
                } else if (productType.equals("Drink")) { // code, name, price
                    currentProduct = new Drink(tokens[0], tokens[1], new BigDecimal(tokens[2]));
                } else if (productType.equals("Gum")) { // code, name, price
                    currentProduct = new Gum(tokens[0], tokens[1], new BigDecimal(tokens[2]));
                }
                if (currentProduct != null) {
                    productMap.put(currentProduct.getCode(), currentProduct);
                }
            }
        } catch (FileNotFoundException ex){
            // good place to log the FileNotFoundException (Checked Exception)
            // throw DataAccessException (Unchecked Exception) to other application layers
            // no information in message that may undermine security considerations.
            throw new DataAccessException("Data access error.");
        }
        return productMap;
    }
}
