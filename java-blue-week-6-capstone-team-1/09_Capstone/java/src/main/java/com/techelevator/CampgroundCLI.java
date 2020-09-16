package com.techelevator;

import javax.sql.DataSource;

import View.Menu;
import View.UserInput;
import Model.JDBCCampDAO.*;
import org.apache.commons.dbcp2.BasicDataSource;

public class CampgroundCLI {


	public static void main(String[] args) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		UserInput userInput = new UserInput( new JDBCParkDAO(dataSource) );

		userInput.run();
	}
}
