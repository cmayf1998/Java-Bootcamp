package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCDepartmentDAO implements DepartmentDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCDepartmentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Department> getAllDepartments() {

		ArrayList<Department> departments = new ArrayList<>();
		String sqlgetDepartments = "SELECT department_id, name FROM department ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlgetDepartments);
		while(results.next()) {

			Department newDepartment = new Department(results.getLong("department_id"), results.getString("name"));
			departments.add(newDepartment);
		}
		return departments;
	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch)
	{
		ArrayList<Department> departments = new ArrayList<>();
		String sqlgetDepartments = "SELECT department_id, name FROM department WHERE name = " + "'" + nameSearch + "'";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlgetDepartments);
		while(results.next()) {

			Department newDepartment = new Department(results.getLong("department_id"), results.getString("name"));
			departments.add(newDepartment);
		}
		return departments;
	}


	@Override
	public Department getDepartmentById(Long id) {

		String sqlgetDepartments = "SELECT department_id, name FROM department WHERE department_id = " + "'" + id + "'";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlgetDepartments);
		while(results.next()) {

			return new Department(results.getLong("department_id"), results.getString("name"));

		}
		return null;
	}




	@Override
	public void saveDepartment(Department updatedDepartment) {
		String sqlInsertDep = "UPDATE department " +
				"SET name = " + "'" + updatedDepartment.getName() + "'" +
				" WHERE department_id = " + updatedDepartment.getId();

		jdbcTemplate.update(sqlInsertDep);
	}

	@Override
	public Department createDepartment(Department newDepartment) {
		String sqlInsertDep = "INSERT INTO department(department_id, name) " +
				"VALUES(?, ?)";
		newDepartment.setId(getNextDepId());
		jdbcTemplate.update(sqlInsertDep,
				newDepartment.getId(),
				newDepartment.getName());
		return newDepartment;
	}



	private long getNextDepId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_department_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new department");
		}
	}

}
