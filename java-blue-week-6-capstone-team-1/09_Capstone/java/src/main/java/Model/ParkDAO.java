package Model;

import java.time.LocalDate;
import java.util.List;

public interface ParkDAO {
    List<Park> getAllParks();
    List<Campground> getAllCampgrounds(Long parkId);
    List<Site> reservationSearch(int campgroundChoice, LocalDate arrivalDate, LocalDate departureDate);
}

