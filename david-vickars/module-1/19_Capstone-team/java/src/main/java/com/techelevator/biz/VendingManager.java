package com.techelevator.biz;

import com.techelevator.data.ProductDao;
import com.techelevator.entity.Customer;
import com.techelevator.entity.Product;

import java.util.Map;

public class VendingManager {

    // Using the interface creates a loosely coupled relationship between VendingManager's
    // dependency on ProductDao. Can now use different implementations in VendingManager
    // to get the Product data. For example, from a file, from a database, ...
    private ProductDao productDao;

    private Map<String, Product> productMap;

    private Customer customer;

    public VendingManager(ProductDao productDao, Customer customer) throws Exception {
        if (productDao == null){
            throw new Exception("ProductDao is null.");
        }
        this.productDao = productDao;
        this.productMap = this.productDao.getProducts();
        this.customer = customer;
    }

    public String getAllProductsForDisplay(){
        String display = "";
        return display;
    }


}
