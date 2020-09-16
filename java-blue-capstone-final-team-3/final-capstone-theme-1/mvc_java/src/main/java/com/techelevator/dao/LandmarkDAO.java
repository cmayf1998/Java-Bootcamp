package com.techelevator.dao;

import com.techelevator.entity.Landmark;
import com.techelevator.entity.LandmarkFilter;

import java.util.List;

public interface LandmarkDAO{

    Landmark getById(int landmarkId);

    List<Landmark> getAll();

    void updateRating(Landmark landmark);

}
