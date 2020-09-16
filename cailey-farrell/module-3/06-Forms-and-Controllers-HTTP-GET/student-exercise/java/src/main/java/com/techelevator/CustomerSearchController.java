package com.techelevator;

import com.techelevator.dao.CustomerDao;
import com.techelevator.dao.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class CustomerSearchController {

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping(path={"/searchCustomers", "/"}, method = RequestMethod.GET)
    public String showSearchCustomerForm(){
        return "customerList";
    }

    @RequestMapping(path="/searchCustomers", method = RequestMethod.POST)
    public String searchCustomers(
            @RequestParam String searchName,
            @RequestParam String sortOrder,
            ModelMap modelMap){
        List<Customer> customers = customerDao.searchAndSortCustomers(searchName, sortOrder);
        modelMap.put("customers",customers);
        return "customerList";
    }

}