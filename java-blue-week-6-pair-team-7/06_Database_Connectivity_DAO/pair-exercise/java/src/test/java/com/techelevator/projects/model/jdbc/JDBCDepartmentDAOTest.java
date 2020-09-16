package com.techelevator.projects.model.jdbc;

import com.techelevator.projects.model.Department;
import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class JDBCDepartmentDAOTest {

    private static SingleConnectionDataSource dataSource;
    private JDBCDepartmentDAO dao;
    Department subject = new Department((long) 100, "Parks Department");

    @BeforeClass
    public static void setupDataSource() {
        dataSource = new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/project-pair");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        /* The following line disables autocommit for connections
         * returned by this DataSource. This allows us to rollback
         * any changes after each test */
        dataSource.setAutoCommit(false);
    }

    /* After all tests have finished running, this method will close the DataSource */
    @AfterClass
    public static void closeDataSource() throws SQLException {
        dataSource.destroy();
    }

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        dao = new JDBCDepartmentDAO(dataSource);
        dao.createDepartment(subject);
    }

    /* After each test, we rollback any changes that were made to the database so that
     * everything is clean for the next test */
    @After
    public void rollback() throws SQLException {
        dataSource.getConnection().rollback();
    }

    @Test
    public void getAllDepartments() {
        assertEquals(subject.getId(), dao.getAllDepartments().get(dao.getAllDepartments().size() - 1).getId());
        assertEquals(subject.getName(), dao.getAllDepartments().get(dao.getAllDepartments().size() - 1).getName());
    }

    @Test
    public void searchDepartmentsByName() {
        assertEquals(subject.getName(), dao.searchDepartmentsByName("Parks Department").get(0).getName());
    }

    @Test
    public void getDepartmentById() {
        assertEquals(subject.getName(),  dao.getDepartmentById(subject.getId()).getName());
    }

    @Test
    public void saveDepartment() {
        dao.saveDepartment(new Department(subject.getId(), "Parks&Rec"));
        assertEquals("Parks&Rec", dao.getDepartmentById(subject.getId()).getName());
    }

    @Test
    public void createDepartment() {
        Department created = dao.createDepartment(new Department((long) 55, "Police Department" ));
        assertEquals("Police Department",  dao.getDepartmentById(created.getId()).getName());

    }
}