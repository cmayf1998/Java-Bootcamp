package com.techelevator.projects.model.jdbc;

import com.techelevator.projects.model.Employee;
import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JDBCProjectDAOTest {

    private static SingleConnectionDataSource dataSource;
    private JDBCProjectDAO dao;
    private JDBCEmployeeDAO emplDao;


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
        dao = new JDBCProjectDAO(dataSource);
        emplDao = new JDBCEmployeeDAO(dataSource);
        //dao.createEmployee(subject);

    }

    /* After each test, we rollback any changes that were made to the database so that
     * everything is clean for the next test */
    @After
    public void rollback() throws SQLException {
        dataSource.getConnection().rollback();
    }

    @Test
    public void getAllActiveProjects() {
        assertEquals( 6, dao.getAllActiveProjects().size());
    }

    @Test
    public void addEmployeeToProject() {
        List testList = emplDao.getEmployeesByProjectId((long)1);
        List<Long> tester = new ArrayList<>();
        for(int i = 0; i < testList.size(); i ++){
            tester.add(emplDao.getEmployeesByProjectId((long)1).get(i).getId());
        }
        assertTrue(tester.contains((long)3));
        assertTrue(tester.contains((long)5));
        assertFalse(tester.contains((long)4));

        dao.addEmployeeToProject((long) 1, (long) 4);
        List<Long> testerUpdated = new ArrayList<>();
        testList = emplDao.getEmployeesByProjectId((long)1);
        for(int i = 0; i < testList.size(); i ++){
            testerUpdated.add(emplDao.getEmployeesByProjectId((long)1).get(i).getId());
        }

        assertTrue(testerUpdated.contains((long)4));
    }

    @Test
    public void removeEmployeeFromProject() {
        List testList = emplDao.getEmployeesByProjectId((long)1);
        List<Long> tester = new ArrayList<>();
        for(int i = 0; i < testList.size(); i ++){
            tester.add(emplDao.getEmployeesByProjectId((long)1).get(i).getId());
        }
        assertTrue(tester.contains((long)3));
        assertTrue(tester.contains((long)5));
        assertFalse(tester.contains((long)4));

        dao.removeEmployeeFromProject((long) 1, (long) 5);
        List<Long> testerUpdated = new ArrayList<>();
        testList = emplDao.getEmployeesByProjectId((long)1);
        for(int i = 0; i < testList.size(); i ++){
            testerUpdated.add(emplDao.getEmployeesByProjectId((long)1).get(i).getId());
        }

        assertFalse(testerUpdated.contains((long)5));
    }


}