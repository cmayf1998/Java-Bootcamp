package com.techelevator.city;

import java.util.List;

public interface CityDAO {

	// Basic CRUD API for our city database
	public void save(City newCity);
	public City findCityById(long id);
	public List<City> findCityByCountryCode(String countryCode);
	public List<City> findCityByDistrict(String district);
	public void update(City city);
	public void delete(long id);
}
