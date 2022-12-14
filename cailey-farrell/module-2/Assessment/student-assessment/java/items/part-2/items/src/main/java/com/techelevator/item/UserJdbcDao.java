package com.techelevator.item;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class UserJdbcDao implements UserDao {

	private JdbcTemplate jdbcTemplate;

	public UserJdbcDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// To insert a date into a prepared statement, wrap the date in
	// `Date.valueOf()`
	// method: `Date.valueOf(myObject.getCreated())`

	@Override
	public void save(User newUser) {
		// Implement this method to save user to database
		String sqlInsertUser = "INSERT INTO users (first_name, last_name, email, role, created)" + "VALUES(?,?,?,?,?) RETURNING id";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlInsertUser,
				newUser.getFirstName(),
				newUser.getLastName(),
				newUser.getEmail(),
				newUser.getRole(),
				Date.valueOf(newUser.getCreated())
		);

		if (results.next()) {
			newUser.setId(results.getLong("id"));
		}
	}

	@Override
	public List<User> getAllUsers() {
		// Implement this method to pull in all users from database
		List<User> users = new ArrayList<>();
		String sql = "SELECT * FROM users";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()){
			users.add(mapRowToUser(results));
		}

		return users;
	}

	private User mapRowToUser(SqlRowSet results) {
		User userRow = new User();
		userRow.setId(results.getLong("id"));
		userRow.setFirstName(results.getString("first_name"));
		userRow.setLastName(results.getString("last_name"));
		userRow.setEmail(results.getString("email"));
		userRow.setRole(results.getString("role"));
		userRow.setCreated(results.getDate("created").toLocalDate());
		return userRow;
	}
//
//	@Override
//	public List<User> getAllDetailsInAllUsers() {
//		List<User> users = new ArrayList<>();
//		String sql = "SELECT first_name, last_name FROM users";
//		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
//		while(results.next()){
//			users.add(mapRowToUser(results));
//		}
//
//		return users;
//	}

}
