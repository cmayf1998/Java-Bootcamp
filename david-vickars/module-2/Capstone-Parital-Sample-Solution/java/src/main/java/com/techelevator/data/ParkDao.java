package com.techelevator.data;

import com.techelevator.entity.Campground;
import com.techelevator.entity.Park;
import com.techelevator.entity.Reservation;
import com.techelevator.entity.Site;

import java.time.LocalDate;
import java.util.List;

public interface ParkDao {

    List<Park> getParks(boolean cascade);

    Park getParkByPk(int id, boolean cascade);

    List<Campground> getCampgroundsForPark(int parkId, boolean cascade);

    List<Campground> getCampgroundsForPark(int parkId, boolean cascade, Park park);

    List<Site> getSitesForCampground(int campgroundId, boolean cascade);

    List<Site> getSitesForCampground(int campgroundId, boolean cascade, Campground campground);

    List<Reservation> getReservationsForSite(int siteId);

    List<Reservation> getReservationsForSite(int siteId, Site site);

    boolean isCampgroundOpen(Campground campground, LocalDate fromDate, LocalDate toDate);

    List<Site> getAvailableSites(Campground campground, LocalDate fromDate, LocalDate toDate);
}
