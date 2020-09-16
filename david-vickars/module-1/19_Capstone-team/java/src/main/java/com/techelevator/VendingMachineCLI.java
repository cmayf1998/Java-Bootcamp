package com.techelevator;

import com.techelevator.biz.VendingManager;
import com.techelevator.data.ProductDaoDb;
import com.techelevator.data.ProductDaoFile;
import com.techelevator.entity.Customer;
import com.techelevator.exceptions.DataAccessException;
import com.techelevator.view.Menu;
import com.techelevator.view.UserInput;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class VendingMachineCLI {

	// Configure and start the application...
	public static void main(String[] args) {
		VendingManager manager = null;
		try {
			manager = new VendingManager(
					new ProductDaoDb(getDataSource()),
					// new ProductDaoFile(),
					new Customer());
		} catch (Exception ex){
			System.out.println("Error: " + ex.getMessage());

		}
		UserInput userInput = new UserInput(manager);
		userInput.run();
	}

	public static DataSource getDataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/capmod1");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		return dataSource;
	}
}
