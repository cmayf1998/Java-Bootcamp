package com.techelevator.data;

import com.techelevator.entity.*;
import com.techelevator.log.Logger;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ParkDaoJDBC implements ParkDao {

    private JdbcTemplate jdbcTemplate;

    public ParkDaoJDBC(DataSource dataSource){

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Park> getParks(boolean cascade){
        List<Park> parks = new ArrayList<>();
        String sql =
                " SELECT *" +
                " FROM park" +
                " ORDER BY name";
        try {
            parks = jdbcTemplate.query(
                    sql, new Object[]{},
                    (rs, rowNum) -> {
                        return getParkFromRs(rs);
                    }
            );
            if (cascade && (parks.size() > 0)) {
                for (Park park : parks) {
                    if ((park != null) && (park.getId() != 0)) {
                        park.setCampgrounds(getCampgroundsForPark(park.getId(), true, park));
                    }
                }
            }
        } catch (Exception ex){
            Logger.logTimeStampedMessage("Error getParks: " + ex.getMessage());
        }
        return parks;
    }

    @Override
    public Park getParkByPk(int id, boolean cascade){
        String sql = "SELECT * FROM Park WHERE park_id = ?";

        Park park = jdbcTemplate.queryForObject(
                sql, new Object[]{id},
                (rs, rowNum) -> {
                    return getParkFromRs(rs);
                });
        if (cascade && (park != null) && (park.getId() != 0)){
            park.setCampgrounds( getCampgroundsForPark(park.getId(), true, park) );
        }
        return park;
    }

    @Override
    public List<Campground> getCampgroundsForPark(int parkId, boolean cascade){
        return getCampgroundsForPark(parkId, cascade, null);
    }

    @Override
    public List<Campground> getCampgroundsForPark(int parkId, boolean cascade, Park park){
        List<Campground> campgrounds = new ArrayList<>();
        String sql =
                " SELECT *" +
                        " FROM campground" +
                        " WHERE park_id = ?" +
                        " ORDER BY name";

        campgrounds = jdbcTemplate.query(
                sql, new Object[]{parkId},
                (rs, rowNum) -> {
                    return getCampgroundFromRs(rs);
                }
        );
        if (cascade && (campgrounds.size() > 0)){
            for (Campground campground : campgrounds){
                if ((park != null) && (park.getId() != 0)){
                    campground.setPark(park);
                }
                campground.setSites( getSitesForCampground(campground.getId(), true, campground) );
            }
        }
        return campgrounds;
    }

    @Override
    public List<Site> getSitesForCampground(int campgroundId, boolean cascade){
        return getSitesForCampground(campgroundId, cascade, null);
    }

    @Override
    public List<Site> getSitesForCampground(int campgroundId, boolean cascade, Campground campground){
        List<Site> sites = new ArrayList<>();
        String sql =
                "SELECT * FROM site WHERE campground_id = ?";

        sites = jdbcTemplate.query(
                sql, new Object[]{campgroundId},
                (rs, rowNum) -> {
                    return getSiteFromRs(rs);
                }
        );
        if (cascade && (sites.size() > 0)){
            for (Site site : sites){
                if (campground != null){
                    site.setCampground(campground);
                }
                site.setReservations( getReservationsForSite(site.getId(), site) );
            }
        }
        return sites;
    }

    @Override
    public List<Reservation> getReservationsForSite(int siteId){
        return getReservationsForSite(siteId, null);
    }

    @Override
    public List<Reservation> getReservationsForSite(int siteId, Site site){
        List<Reservation> reservations = new ArrayList<>();
        String sql =
                "SELECT * FROM reservation WHERE site_id = ?";

        reservations = jdbcTemplate.query(
                sql, new Object[]{siteId},
                (rs, rowNum) -> {
                    return getReservationFromRs(rs);
                }
        );
        if ( (reservations.size() > 0) ){
            for (Reservation reservation : reservations){
                if (site != null){
                    reservation.setSite(site);
                }
            }
        }
        return reservations;
    }

    private Park getParkFromRs(ResultSet rs) throws SQLException {
        return new Park(
                rs.getInt("park_id"),
                rs.getString("name"),
                rs.getString("location"),
                rs.getTimestamp("establish_date").toLocalDateTime().toLocalDate(),
                rs.getInt("area"),
                rs.getLong("visitors"),
                rs.getString("description"));
    }

    private Campground getCampgroundFromRs(ResultSet rs) throws SQLException {
        return new Campground(
                rs.getInt("campground_id"),
                rs.getString("name"),
                rs.getString("open_from_mm"),
                rs.getString("open_to_mm"),
                new Money( rs.getBigDecimal("daily_fee") ));
    }

    private Site getSiteFromRs(ResultSet rs) throws SQLException {
        return new Site(
                rs.getInt("site_id"),
                rs.getInt("site_number"),
                rs.getInt("max_occupancy"),
                rs.getBoolean("accessible"),
                rs.getInt("max_rv_length"),
                rs.getBoolean("utilities") );
    }

    private Reservation getReservationFromRs(ResultSet rs) throws SQLException {
        return new Reservation(
                rs.getInt("reservation_id"),
                rs.getString("name"),
                rs.getTimestamp("from_date").toLocalDateTime().toLocalDate(),
                rs.getTimestamp("to_date").toLocalDateTime().toLocalDate(),
                rs.getTimestamp("create_date").toLocalDateTime().toLocalDate() );
    }

    @Override
    public boolean isCampgroundOpen(Campground campground, LocalDate fromDate, LocalDate toDate){
        int campgroundFromMonth = Integer.parseInt( campground.getMonthOpen() );
        int campgroundToMonth = Integer.parseInt( campground.getMonthClosed() );
        int requestFromMonth = fromDate.getMonthValue();
        int requestToMonth = toDate.getMonthValue();

        if (requestFromMonth < campgroundFromMonth)
            return false;
        if (requestFromMonth > campgroundToMonth)
            return false;
        if (requestToMonth < campgroundFromMonth)
            return false;
        if (requestToMonth > campgroundToMonth)
            return false;

        return true;
    }

    @Override
    public List<Site> getAvailableSites(Campground campground, LocalDate fromDate, LocalDate toDate){
        if (!isCampgroundOpen(campground, fromDate, toDate)){
            return null;
        }
        List<Site> availableSites = new ArrayList<>();

        String sql =
                " SELECT * FROM site" +
                " JOIN campground ON site.campground_id = campground.campground_id" +
                " WHERE site.campground_id = ?" +
                " AND site.site_id NOT IN" +
                " (" +
                    " SELECT s.site_id FROM site s" +
                    " JOIN reservation r ON s.site_id = r.site_id" +
                    " WHERE s.campground_id = ?" +
                    " AND" +
                        "(" +
                            " ? > r.from_date AND ? < r.to_date" +
                            " OR ? > r.from_date AND ? < r.to_date" +
                        ")" +
                    " OR" +
                        "(" +
                            " r.from_date BETWEEN ? AND ?" +
                            " AND" +
                            " r.to_date BETWEEN ? AND ?" +
                        ")" +
                " );";

        availableSites = jdbcTemplate.query(
                sql, new Object[]{
                        campground.getId(), campground.getId(),
                        fromDate, fromDate,
                        toDate, toDate,
                        fromDate, toDate,
                        fromDate, toDate},
                (rs, rowNum) -> {
                    return getSiteFromRs(rs);
                }
        );
        return availableSites;
    }
}
