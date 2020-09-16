package com.techelevator.biz;

import com.techelevator.data.ParkDao;
import com.techelevator.entity.Campground;
import com.techelevator.entity.Park;

import java.util.List;


/**
 * Note at this point the method implementations simply call their DAO counterpart.
 * This is known as a Facade Pattern. The ParkManager is holding the business layer
 * for future extensibility even though currently no real business process logic exists.
 */
public class ParkManager {

    private ParkDao parkDao;

    private Park selectedPark;

    public ParkManager(ParkDao parkDao){
        this.parkDao = parkDao;
    }

    public List<Park> getParks(boolean cascade){
        return parkDao.getParks(cascade);
    }

    public Park getSelectedPark() {
        return selectedPark;
    }

    public void setSelectedPark(Park selectedPark) {
        this.selectedPark = selectedPark;
    }

    public List<Campground> getCampgrounds(boolean cascade){
        return parkDao.getCampgroundsForPark(selectedPark.getId(), cascade);
    }
}
