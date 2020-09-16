package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCEmployeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {

		ArrayList<Employee> employees = new ArrayList<>();
		String sqlgetEmployees = "SELECT * FROM employee ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlgetEmployees);
		while(results.next()) {

			Employee newEmployee = new Employee(results.getLong("employee_id"), results.getLong("department_id"),
					results.getString("first_name"), results.getString("last_name"), results.getDate("birth_date").toLocalDate(),
					results.getString("gender").charAt(0), results.getDate("hire_date").toLocalDate());
			employees.add(newEmployee);
		}
		return employees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		ArrayList<Employee> employees = new ArrayList<>();
		String sqlgetEmployees = "SELECT * FROM employee WHERE first_name = '" + firstNameSearch + "' AND last_name = '" + lastNameSearch + "';";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlgetEmployees);
		while (results.next()) {

			Employee newEmployee = new Employee(results.getLong("employee_id"), results.getLong("department_id"),
					results.getString("first_name"), results.getString("last_name"), results.getDate("birth_date").toLocalDate(),
					results.getString("gender").charAt(0), results.getDate("hire_date").toLocalDate());
			employees.add(newEmployee);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		ArrayList<Employee> employees = new ArrayList<>();
		String sqlgetEmployees = "SELECT * FROM employee WHERE department_id = '" + id + "';";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlgetEmployees);
		while (results.next()) {

			Employee newEmployee = new Employee(results.getLong("employee_id"), results.getLong("department_id"),
					results.getString("first_name"), results.getString("last_name"), results.getDate("birth_date").toLocalDate(),
					results.getString("gender").charAt(0), results.getDate("hire_date").toLocalDate());
			employees.add(newEmployee);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		ArrayList<Employee> employees = new ArrayList<>();
		String sqlgetEmployees = "SELECT * FROM employee LEFT JOIN project_employee ON employee.employee_id = project_employee.employee_id WHERE project_id IS NULL";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlgetEmployees);
		while (results.next()) {

			Employee newEmployee = new Employee(results.getLong("employee_id"), results.getLong("department_id"),
					results.getString("first_name"), results.getString("last_name"), results.getDate("birth_date").toLocalDate(),
					results.getString("gender").charAt(0), results.getDate("hire_date").toLocalDate());
			employees.add(newEmployee);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		ArrayList<Employee> employees = new ArrayList<>();
		String sqlgetEmployees = "SELECT * FROM employee LEFT JOIN project_employee ON employee.employee_id = project_employee.employee_id WHERE project_id  = '" + projectId +  "'";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlgetEmployees);
		while (results.next()) {

			Employee newEmployee = new Employee(results.getLong("employee_id"), results.getLong("department_id"),
					results.getString("first_name"), results.getString("last_name"), results.getDate("birth_date").toLocalDate(),
					results.getString("gender").charAt(0), results.getDate("hire_date").toLocalDate());
			employees.add(newEmployee);
		}
		return employees;
	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		String sqlInsertCity = "UPDATE employee " +
				"SET department_id = " + departmentId + " WHERE employee_id = " + employeeId;

		jdbcTemplate.update(sqlInsertCity);
	}

	public Employee createEmployee(Employee newEmployee) {
		String sqlInsertDep = "INSERT INTO employee(first_name, last_name, birth_date, gender, hire_date, department_id) " +
				"VALUES(?, ?, ?, ?, ?, ?)";
		newEmployee.setId(getNextEmployeeId());
		jdbcTemplate.update(sqlInsertDep,
				newEmployee.getFirstName(),
				newEmployee.getLastName(),
				newEmployee.getBirthDay(),
				newEmployee.getGender(),
				newEmployee.getHireDate(),
				newEmployee.getDepartmentId()
				);
		return newEmployee;
	}

	private long getNextEmployeeId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_employee_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new employee");
		}
	}

}
