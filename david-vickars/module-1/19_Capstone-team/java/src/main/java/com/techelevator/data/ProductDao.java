package com.techelevator.data;

import com.techelevator.entity.Product;
import com.techelevator.exceptions.DataAccessException;

import java.util.Map;

public interface ProductDao {

    Map<String, Product> getProducts() throws DataAccessException;

    Map<String, Product> getProducts(String connectionString, String delimiter) throws DataAccessException;
}
