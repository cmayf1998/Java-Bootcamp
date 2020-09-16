package com.techelevator.projects.model.jdbc;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;
import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JDBCEmployeeDAOTest {
    private static SingleConnectionDataSource dataSource;
    private JDBCEmployeeDAO dao;
    Employee subject = new Employee((long) 1500.0, (long) 4,(String) "Bob", (String) "Thebuilder",  LocalDate.parse("1996-05-06") ,  "M".charAt(0),  LocalDate.parse("2010-07-28"));
    Employee subject2 = new Employee((long) 1500.0, (long) 4,(String) "Ella", (String) "Of_Frell",  LocalDate.parse("1996-05-06") ,  "M".charAt(0),  LocalDate.parse("2010-07-28"));


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
        dao = new JDBCEmployeeDAO(dataSource);
       //dao.createEmployee(subject);
        dao.createEmployee(subject);

    }

    /* After each test, we rollback any changes that were made to the database so that
     * everything is clean for the next test */
    @After
    public void rollback() throws SQLException {
        dataSource.getConnection().rollback();
    }

    @Test
    public void getAllEmployees() {
        assertEquals(subject.getFirstName(), dao.getAllEmployees().get(dao.getAllEmployees().size() -1).getFirstName());
        assertEquals(subject.getLastName(), dao.getAllEmployees().get(dao.getAllEmployees().size() -1).getLastName());
    }

    @Test
    public void searchEmployeesByName() {
        assertEquals(subject.getFirstName(), dao.searchEmployeesByName("Bob", "Thebuilder").get(0).getFirstName());
        assertEquals(subject.getLastName(), dao.searchEmployeesByName("Bob", "Thebuilder").get(0).getLastName());
    }

    @Test
    public void getEmployeesByDepartmentId() {
        assertEquals(subject.getFirstName(), dao.getEmployeesByDepartmentId(subject.getDepartmentId()).get(dao.getEmployeesByDepartmentId(subject.getDepartmentId()).size() - 1).getFirstName());
        assertEquals(subject.getLastName(), dao.getEmployeesByDepartmentId(subject.getDepartmentId()).get(dao.getEmployeesByDepartmentId(subject.getDepartmentId()).size() - 1).getLastName());
    }

    @Test
    public void getEmployeesWithoutProjects() {

        List testList = dao.getEmployeesWithoutProjects();
        List<String> tester = new ArrayList<>();
        for(int i = 0; i < testList.size(); i ++){
            tester.add(dao.getEmployeesWithoutProjects().get(i).toString());
        }
        assertTrue(tester.contains(subject.toString()));
    }

    @Test
    public void getEmployeesByProjectId() {
        List testList = dao.getEmployeesByProjectId((long)1);
        List<Long> tester = new ArrayList<>();
        for(int i = 0; i < testList.size(); i ++){
            tester.add(dao.getEmployeesByProjectId((long)1).get(i).getId());
        }
        assertTrue(tester.contains((long)3));
        assertTrue(tester.contains((long)5));
        assertFalse(tester.contains((long)4));

    }

    @Test
    public void changeEmployeeDepartment() {
        dao.changeEmployeeDepartment((long)1, (long) 3);
        List<String> tester = new ArrayList<>();
        for(int i = 0; i < dao.getEmployeesByDepartmentId((long) 3).size(); i ++){
            tester.add(dao.getEmployeesByDepartmentId((long)3).get(i).toString());
        }
        assertTrue(tester.contains(dao.searchEmployeesByName("Fredrick", "Keppard").get(0).toString()));
    }
}