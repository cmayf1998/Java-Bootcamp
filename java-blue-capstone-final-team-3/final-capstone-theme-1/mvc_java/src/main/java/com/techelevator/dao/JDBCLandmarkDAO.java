package com.techelevator.dao;

import com.techelevator.entity.DayOfWeek;
import com.techelevator.entity.Landmark;
import com.techelevator.entity.LandmarkFilter;
import com.techelevator.security.PasswordHasher;
import org.apache.taglibs.standard.tag.el.sql.UpdateTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCLandmarkDAO implements LandmarkDAO{

    private JdbcTemplate jdbcTemplate;



    @Autowired
    public JDBCLandmarkDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Landmark getById(int landmarkId) {
        SqlRowSet result = jdbcTemplate.queryForRowSet("SELECT * FROM landmark WHERE landmark_id = ?", landmarkId);
        if (result.next()) {
            return mapRowSetToLandmark(result);
        }
        return null;
    }

    @Override
    public List<Landmark> getAll() {
        SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT * FROM landmark");
//        if (results.next()) {
//            return mapRowSetToLandmarks(results);
//        }
        return mapRowSetToLandmarks(results);
    }


    @Override
    public void updateRating(Landmark landmark) {

        String sqlUpdateRating = "UPDATE landmark SET likes = ?, dislikes = ? WHERE landmark_id = ?";
        jdbcTemplate.update(sqlUpdateRating, landmark.getLikes(), landmark.getDislikes(), landmark.getLandmarkId());
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
        landmark.setLikes(results.getInt("likes"));
        landmark.setDislikes(results.getInt("dislikes"));
        return landmark;
    }


}

