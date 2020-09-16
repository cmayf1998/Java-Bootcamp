package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import javax.sql.DataSource;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCProjectDAO implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCProjectDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Project> getAllActiveProjects() {
		ArrayList<Project> projects = new ArrayList<>();
		String sqlgetProjects = "SELECT * FROM project ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlgetProjects);
		while (results.next()) {
			Project newProject = null;
			if((results.getDate("from_date") != null) && (results.getDate("to_date"))!= null){
				newProject = mapToProject(results.getLong("project_id"), results.getString("name"),
						results.getDate("from_date").toLocalDate(), results.getDate("to_date").toLocalDate());
			} else if ((results.getDate("from_date") == null) && (results.getDate("to_date"))!= null) {
				newProject = mapToProject(results.getLong("project_id"), results.getString("name"),
					null, results.getDate("to_date").toLocalDate());
			} else if ((results.getDate("from_date") != null) && (results.getDate("to_date"))== null){
				newProject = mapToProject(results.getLong("project_id"), results.getString("name"),
						results.getDate("from_date").toLocalDate(), null);
			} else {
				newProject = mapToProject(results.getLong("project_id"), results.getString("name"),
						null, null);
			}
			projects.add(newProject);
		}
		return projects;
	}
	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sqlEmployeeRemoval = "DELETE FROM project_employee WHERE project_id = " + projectId + " AND employee_id = " + employeeId;

		jdbcTemplate.update(sqlEmployeeRemoval);
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sqlAddToProject = "INSERT INTO project_employee(project_id, employee_id) " +
				"VALUES(" + projectId + ", " + employeeId +")";

		jdbcTemplate.update(sqlAddToProject);
	}

	public Project mapToProject(long project_id, String name, LocalDate from_date, LocalDate to_date){
		Project newProject = new Project(project_id, name,
				from_date, to_date);

		return newProject;
	}

}
