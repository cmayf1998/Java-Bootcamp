package com.techelevator;

import javax.sql.DataSource;

import com.techelevator.biz.ParkManager;
import com.techelevator.data.ParkDaoJDBC;
import com.techelevator.log.Logger;
import com.techelevator.view.Menu;
import com.techelevator.view.UserInput;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;

public class CampgroundCLI {

	public static void main(String[] args) {
		try {
			// open log file
			Logger.openLogger(Logger.DEFAULT_LOG_FILENAME);

			// intialize ParkManager and it's dependency on ParkDao
			ParkManager parkManager = new ParkManager(
					new ParkDaoJDBC(getDataSource()));

			// create UserInput and pass in it's dependency on ParkManager
			UserInput application = new UserInput(parkManager);

			// start the application running
			application.run();
		} catch (Exception ex){
			System.out.println("Error: " + ex.getMessage());
		}
	}

	private static DataSource getDataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		return dataSource;
	}
}
