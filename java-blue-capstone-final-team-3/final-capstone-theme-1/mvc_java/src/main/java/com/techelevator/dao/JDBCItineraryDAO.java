package com.techelevator.dao;

import com.techelevator.entity.DayOfWeek;
import com.techelevator.entity.Itinerary;
import com.techelevator.entity.Landmark;
import com.techelevator.security.PasswordHasher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Component
public class JDBCItineraryDAO implements ItineraryDAO {
    private JdbcTemplate jdbcTemplate;
    private PasswordHasher hashMaster;


    @Autowired
    public JDBCItineraryDAO(DataSource dataSource, PasswordHasher hashMaster) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.hashMaster = hashMaster;
    }

    //Delete itinerary from itinerary page based off of logged in user
    @Override
    public void deleteItinerary(int itineraryId) {
        String sql = "DELETE FROM itinerary_landmark WHERE itinerary_id = ?;" +
                " DELETE FROM itinerary WHERE itinerary_id = ?";
        jdbcTemplate.update(sql, itineraryId, itineraryId);
    }
    //Edit an itinerary based on the logged in user
    @Override
    public void editItinerary(Itinerary itinerary) {
        String sql = "UPDATE itinerary SET itinerary_name = ?, " +
                "start_date = ?, end_date = ? WHERE itinerary_id = ?";



        jdbcTemplate.update(sql, itinerary.getItineraryName(), Date.valueOf(itinerary.getStartDate()),Date.valueOf(itinerary.getEndDate()),
                itinerary.getItineraryId());
    }

    @Override
    public void removeLandmarkFromItinerary(int itineraryId, int landmarkId) {
        String sql = "DELETE FROM itinerary_landmark " +
                "WHERE itinerary_id = ? AND  landmark_id = ?";
        jdbcTemplate.update(sql, itineraryId, landmarkId);
    }

    // must add landmark to itinerary in database according to logged in user
    @Override
    public void addLandmarkToItinerary(int itineraryId, int landmarkId) {

        String sql = "INSERT INTO itinerary_landmark (itinerary_id, landmark_id) " +
                "VALUES(?,?)";
        jdbcTemplate.update(sql, itineraryId, landmarkId);
    }

    //method that will populate the itinerary jsp based off the logged in user
    @Override
    public List<Itinerary> getAllItineraries(Long userId) {
        SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT * FROM itinerary WHERE user_id = ?", userId);
        return mapRowSetToItineraries(results);
    }

    @Override
    public void addLandmarkAsStartingPoint(int itineraryId) {
        jdbcTemplate.update("UPDATE itinerary SET starting_point = (SELECT landmark_name " +
                "FROM landmark l JOIN itinerary_landmark il ON l.landmark_id = il.landmark_id " +
                "WHERE itinerary_id = ? LIMIT 1) WHERE itinerary_id = ?;", itineraryId, itineraryId);
    }

    //method that will make the submit button in itinerary form work
    @Override
    public void addItinerary(Itinerary itinerary, Long userId) {
        String sql = "INSERT INTO itinerary (user_id, itinerary_name, starting_point, start_date, end_date)" +
                "VALUES(?,?,?,?,?) ";
        jdbcTemplate.update(sql, userId,
                itinerary.getItineraryName(),
                itinerary.getStartingPoint(),
                itinerary.getStartDate(),
                itinerary.getEndDate());

    }

    @Override
    public Itinerary getItineraryById(int itineraryId) {
        SqlRowSet result = jdbcTemplate.queryForRowSet("SELECT * FROM itinerary WHERE itinerary_id = ?", itineraryId);
        if (result.next()) {
            return mapRowSetToItinerary(result);
        }
        return null;
    }

    @Override
    public List<Landmark> getAllLandmarksForItineraryId(int itineraryId) {
        SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT * FROM itinerary_landmark il " +
                "JOIN landmark l ON il.landmark_id = l.landmark_id " +
                "WHERE itinerary_id = ?", itineraryId);
        return mapRowSetToLandmarks(results);
    }

    private List<Itinerary> mapRowSetToItineraries(SqlRowSet results) {
        List<Itinerary> itineraries = new ArrayList<>();
        while (results.next()) {
            itineraries.add(mapRowSetToItinerary(results));
        }
        return itineraries;
    }


    private Itinerary mapRowSetToItinerary(SqlRowSet results) {
        Itinerary itinerary = new Itinerary();
        itinerary.setItineraryId(results.getInt("itinerary_id"));
        itinerary.setItineraryName(results.getString("itinerary_name"));
        itinerary.setStartingPoint(results.getString("starting_point"));
        itinerary.setStartDate(results.getDate("start_date").toLocalDate());
        itinerary.setEndDate(results.getDate("end_date").toLocalDate());

        return itinerary;
    }

    private List<Landmark> mapRowSetToLandmarks(SqlRowSet results) {
        List<Landmark> landmarks = new ArrayList<>();
        while (results.next()) {
            landmarks.add(mapRowSetToLandmark(results));
        }
        return landmarks;
    }

    private Landmark mapRowSetToLandmark(SqlRowSet results) {
        Landmark landmark = new Landmark();
        landmark.setLandmarkId(results.getInt("landmark_id"));
        landmark.setCityId(results.getInt("city_id"));
        landmark.setLandmarkName(results.getString("landmark_name"));
        landmark.setAddress(results.getString("address"));
        landmark.setDayOpen(DayOfWeek.getDayOfWeek(results.getInt("day_open")));
        landmark.setDayClose(DayOfWeek.getDayOfWeek(results.getInt("day_close")));
        landmark.setOpeningTime(results.getTime("opening_time").toLocalTime());
        landmark.setClosingTime(results.getTime("closing_time").toLocalTime());
        landmark.setVenueType(results.getString("venue_type"));
        landmark.setImageUrl(results.getString("image"));
        landmark.setDescription(results.getString("description"));

        return landmark;
    }
}