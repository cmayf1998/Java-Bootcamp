package Model.JDBCCampDAO;

import Model.Campground;
import Model.Park;
import Model.ParkDAO;
import Model.Site;
import View.UserInput;
import jdk.nashorn.internal.scripts.JD;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import sun.java2d.pipe.SpanIterator;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBCParkDAO implements ParkDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCParkDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Park> getAllParks() {
        List<Park> parkList = new ArrayList<>();
        String sql = "SELECT * FROM park";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            parkList.add( mapRowToPark(results) );
        }
        return parkList;
    }

    // How can we revamp this formatting? #help
    private Park mapRowToPark(SqlRowSet results){
        Park park = new Park(
                results.getLong("park_id") ,
                results.getString("name"),
                results.getString("location"),
                results.getDate("establish_date").toLocalDate(),
                results.getInt("area"),
                results.getInt("visitors"),
                results.getString("description")
        );
        return park;
    }

    @Override
    public List<Campground> getAllCampgrounds(Long parkId) {
        List<Campground> campgroundList = new ArrayList<>();
        String sql = "SELECT * FROM campground WHERE park_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);
        while(results.next()) {
            campgroundList.add( mapRowToCampground(results) );
        }
        return campgroundList;
    }

    private Campground mapRowToCampground(SqlRowSet results) {
        Campground campground = new Campground(
                results.getLong("campground_id"),
                results.getInt("park_id"),
                results.getString("name"),
                results.getInt("open_from_mm"),
                results.getInt("open_to_mm"),
                results.getBigDecimal("daily_fee")
                );
        return campground;
    }

    @Override
    public List<Site> reservationSearch(int campgroundChoice, LocalDate arrivalDate, LocalDate departureDate) {
        List <Site> availableSiteList = new ArrayList<>();
//        String sql = "SELECT * FROM site JOIN campground ON site.campground_id = campground.campground_id \n" +
//                "WHERE campground.campground_id = ? AND CAST(open_from_mm AS INT) < ? AND CAST(open_to_mm AS INT) > ?;";
        String sql1 = "SELECT * FROM site\n" +
                "JOIN campground ON site.campground_id = ? \n" +
                "WHERE site.campground_id = ? \n" +
                "AND site.site_id \n" +
                "NOT IN (\n" +
                "        SELECT s.site_id FROM site s\n" +
                "        JOIN reservation r ON s.site_id = r.site_id\n" +
                "        WHERE s.campground_id = ? \n" +
                "        AND (\n ? > r.from_date \n" +
                "                AND ? < r.to_date\n" +
                "                OR ? > r.from_date AND ? < r.to_date\n" +
                "                )\n" +
                "        OR (\n" +
                "                 r.from_date BETWEEN ? AND ?\n" +
                "                AND r.to_date BETWEEN ? AND ?\n" +
                "            )\n" +
                ");";
        SqlRowSet results = jdbcTemplate.queryForRowSet(
                sql1,
                campgroundChoice,
                campgroundChoice,
                campgroundChoice,
                arrivalDate,
                arrivalDate,
                departureDate,
                departureDate,
                arrivalDate,
                departureDate,
                arrivalDate,
                departureDate);

        while(results.next()) {
            availableSiteList.add( mapRowToSite(results) );
        }
        return availableSiteList;
    }


    private  Site mapRowToSite(SqlRowSet results) {
        Site site = new Site(
                results.getLong("site_id"),
                results.getInt("campground_id"),
                results.getInt("site_number"),
                results.getInt("max_occupancy"),
                results.getBoolean("accessible"),
                results.getInt("max_rv_length"),
                results.getBoolean("utilities")
                );
        return site;
    }

    // User is prompted for campground # as well as arrivalDate and departureDate
    // SQL query should check the user dates against 1) campground opening and closing dates and 2) pre-existing reservations
    // If user dates are invalid/nothing is available, print message that tells user to "Try different dates"
    // SELECT for list of sites that are available during the user date range
    // Prompts user to enter site # (enter 0 to cancel) & name
    // When the user enters, the program should 1) INSERT new row into reservation table and 2) print out the reservation ID



}
