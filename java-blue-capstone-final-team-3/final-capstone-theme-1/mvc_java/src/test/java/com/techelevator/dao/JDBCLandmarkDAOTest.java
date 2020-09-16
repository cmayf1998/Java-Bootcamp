package com.techelevator.dao;

import com.techelevator.entity.DayOfWeek;
import com.techelevator.entity.Landmark;
import com.techelevator.entity.LandmarkFilter;
import com.techelevator.security.PasswordHasher;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.*;

public class JDBCLandmarkDAOTest extends DAOIntegrationTest {

    private static final String TEST_CITY = "XYZ";

    private JDBCLandmarkDAO landmarkDAO;
    private JdbcTemplate jdbcTemplate;


    @Before
    public void setUp() throws SQLException {
//        String sqlInsertCity = "INSERT INTO city (city_name) " +
//                " VALUES (?, 'Vancouver')";
        jdbcTemplate = new JdbcTemplate(getDataSource());
//        jdbcTemplate.update(sqlInsertCity, TEST_CITY);
        landmarkDAO = new JDBCLandmarkDAO(getDataSource());
    }

    @Test
    public void testGetLandmarkById() {
        Landmark testLandmark = landmarkDAO.getById(1);

        Landmark expected = new Landmark(1,1, "Parq Casino", "39 Smithe St, Vancouver, BC V6B 5E7, Canada", DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(9,00), LocalTime.of(3, 00), "Casino", "parqCasino.jpg", "Plush riverside resort offering upscale dining, an indoor pool & a spa, plus a casino.", 0, 0);
        assertLandmarksAreEqual(testLandmark, expected);
    }

    @Test
    public void testGetAllLandmarks() {
        Integer numOfLandmarks = 0;
        SqlRowSet result = jdbcTemplate.queryForRowSet("Select count(*) as landmarkCount from landmark");
        if(result.next()){
            numOfLandmarks = result.getInt("landmarkCount");
        }

        List<Landmark> landmarks = landmarkDAO.getAll();

        assertEquals(numOfLandmarks, new Integer(landmarks.size()));
    }


    @Test
    public void updateRating() {
        Landmark landmark = new Landmark(1,1, "Parq Casino", "39 Smithe St, Vancouver, BC V6B 5E7, Canada", DayOfWeek.MONDAY, DayOfWeek.SUNDAY, LocalTime.of(9,00), LocalTime.of(3, 00), "Casino", "parqCasino.jpg", "Plush riverside resort offering upscale dining, an indoor pool & a spa, plus a casino.", 1, 1);
        landmarkDAO.updateRating(landmark);

        assertEquals(landmark.getLikes(), 1);
    }

    private Landmark getLandmark(int landmarkId, int cityId, String landmarkName, String address, DayOfWeek dayOpen, DayOfWeek dayClose, LocalTime openingTime, LocalTime closingTime, String venueType, String imageUrl, String description, int likes, int dislikes){
        Landmark theLandmark = new Landmark(landmarkId, cityId, landmarkName, address, dayOpen, dayClose, openingTime, closingTime, venueType, imageUrl, description, likes, dislikes);
        return  theLandmark;
    };

    private void assertLandmarksAreEqual(Landmark expected, Landmark actual){
        assertEquals(expected.getLandmarkId(), actual.getLandmarkId());
        assertEquals(expected.getCityId(), actual.getCityId());
        assertEquals(expected.getLandmarkName(), actual.getLandmarkName());
        assertEquals(expected.getAddress(), actual.getAddress());
        assertEquals(expected.getDayOpen(), actual.getDayOpen());
        assertEquals(expected.getDayClose(), actual.getDayClose());
        assertEquals(expected.getOpeningTime(), actual.getOpeningTime());
        assertEquals(expected.getClosingTime(), actual.getClosingTime());
        assertEquals(expected.getVenueType(), actual.getVenueType());
        assertEquals(expected.getImageUrl(), actual.getImageUrl());
        assertEquals(expected.getDescription(), actual.getDescription());
        assertEquals(expected.getLikes(), actual.getLikes());
        assertEquals(expected.getDislikes(), actual.getDislikes());
    }
}