package com.techelevator.data;

import com.techelevator.entity.*;
import com.techelevator.exceptions.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProductDaoDb implements ProductDao {

    private JdbcTemplate jdbcTemplate;

    public ProductDaoDb(DataSource dataSource){
       jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Map<String, Product> getProducts() throws DataAccessException {
        return getProducts(null, null);
    }

    @Override
    public Map<String, Product> getProducts(String connectionString, String delimiter)
            throws DataAccessException {
        Map<String, Product> productMap = new LinkedHashMap<>();
        String sqlGetAllProducts =
                "SELECT * FROM products";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllProducts);
        while (results.next()) {
            Product product = mapRowToProduct(results);
            if (product != null) {
                productMap.put(product.getCode(), product);
            }
        }
        return productMap;
    }

    private Product mapRowToProduct(SqlRowSet result) {
        Product currentProduct = null;
        String code = result.getString("product_code");
        String name = result.getString("name");
        BigDecimal price = result.getBigDecimal("price");
        String productType = result.getString("type");
        if (productType.toUpperCase().equals("CHIP")) {
            currentProduct = new Chip(code, name, price);
        } else if (productType.toUpperCase().equals("CANDY")) {
            currentProduct = new Candy(code, name, price);
        } else if (productType.toUpperCase().equals("DRINK")) {
            currentProduct = new Drink(code, name, price);
        } else if (productType.toUpperCase().equals("GUM")) {
            currentProduct = new Gum(code, name, price);
        }
        return currentProduct;
    }
}
