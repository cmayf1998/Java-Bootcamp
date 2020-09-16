package com.techelevator.dao;

import com.techelevator.entity.Itinerary;
import com.techelevator.entity.Landmark;
import com.techelevator.entity.LandmarkFilter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ItineraryDAO {

//    void createItinerary(Itinerary itinerary);

    void deleteItinerary(int itineraryId);

    void editItinerary(Itinerary itinerary);

    void removeLandmarkFromItinerary(int itineraryId, int landmarkId);

    void addLandmarkToItinerary(int itineraryId, int landmarkId);

    void addItinerary(Itinerary itinerary, Long userId);

    List<Landmark> getAllLandmarksForItineraryId(int itineraryId);

    List<Itinerary> getAllItineraries(Long userId);

    Itinerary getItineraryById(int itineraryId);

    void addLandmarkAsStartingPoint(int itineraryId);



}
