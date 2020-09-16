package com.techelevator.controller;

import com.techelevator.dao.ItineraryDAO;
import com.techelevator.dao.LandmarkDAO;
import com.techelevator.entity.Itinerary;
import com.techelevator.entity.Landmark;
import com.techelevator.entity.LandmarkFilter;
import com.techelevator.entity.User;
import com.techelevator.security.AuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(path="/user")
public class LandmarkController {

	@Autowired
	private LandmarkDAO landmarkDao;
	@Autowired
	private ItineraryDAO itineraryDAO;

	public LandmarkController(){
	}

	@RequestMapping(path="/dashboard", method=RequestMethod.GET)
	public String displayDashboard() {
		return "user/dashboard";
	}

	@RequestMapping(path="/search", method=RequestMethod.GET)
	public String displaySearchResults() {
		return "examples/searchResults";
	}

	@RequestMapping(path="/blank", method=RequestMethod.GET)
	public String displayBlankPage() {

		return "common/blank";
	}

	@RequestMapping(path="/404", method=RequestMethod.GET)
	public String displayBadPage() {

		return "common/404";
	}

	@RequestMapping(path="/landmarks", method=RequestMethod.GET)
	public String displayLandmarks(HttpServletRequest request) {

		List<Landmark> landmarks = getLandmarks(request);
		request.setAttribute("landmarks", landmarks);

		return "view/searchLandmarks";
	}

	@RequestMapping(path="/landmarks/rating", method=RequestMethod.GET)
	public String displayLandmarkRating(HttpServletRequest request) {
		String direction = request.getParameter("direction");
		int landmarkId = Integer.parseInt(request.getParameter("id"));
		List<Landmark> landmarks = getLandmarks(request);
		Landmark currentLandmark = null;
		for (Landmark value : landmarks){
			if (value.getLandmarkId() == landmarkId){
				currentLandmark = value;
				break;
			}
		}
		if (direction.equals("like")) {
			currentLandmark.setLikes(currentLandmark.getLikes() + 1);
		} else {
			currentLandmark.setDislikes(currentLandmark.getDislikes() + 1);
		}
		landmarkDao.updateRating(currentLandmark);
		request.setAttribute("landmarks", landmarks);

		return "view/searchLandmarks";
	}

	@RequestMapping(path="/landmarks/details", method=RequestMethod.GET)
	public String displayLandmarkDetails(HttpServletRequest request) {
		int landmarkId = Integer.parseInt(request.getParameter("id"));
		Landmark landmark = landmarkDao.getById(landmarkId);

		request.setAttribute("landmark", landmark);
		return "view/landmarkDetails";
	}

	@RequestMapping(path="/addLandmark", method=RequestMethod.GET)
	public String displayLandmarkOptions(
			HttpServletRequest request,
			@RequestParam int itineraryId,
			Model model ) {

		model.addAttribute("itineraryId", itineraryId);

		List<Landmark> landmarks = getLandmarks(request);
		request.setAttribute("landmarks", landmarks);

		return "view/addLandmarkToItinerary";
	}

	@RequestMapping(path = "/addLandmarkToItinerary", method = RequestMethod.GET)
	public String processAddLandmarkToItinerary(
			@RequestParam int landmarkId,
			@RequestParam int itineraryId) {

		itineraryDAO.addLandmarkToItinerary(itineraryId, landmarkId);
		itineraryDAO.addLandmarkAsStartingPoint(itineraryId);
		return "redirect:itinerary";
	}

	@RequestMapping(path="/itinerary", method=RequestMethod.GET)
	public String displayItinerary(HttpServletRequest request, HttpSession session) {
		Long userId = ( (User)session.getAttribute(AuthorizationFilter.LOGGED_USER) ).getId();

		List<Itinerary> itineraries = itineraryDAO.getAllItineraries(userId);

		request.setAttribute("itineraries", itineraries);
		return "view/itinerary";
	}

	@RequestMapping(path = "/basic/table/landmarkDetails", method = RequestMethod.GET)
	private List<Landmark> getLandmarks(HttpServletRequest request) {
		LandmarkFilter filter = getFilters(request);

		List<Landmark> landmarks = landmarkDao.getAll();

		return landmarks;
	}

	private LandmarkFilter getFilters(HttpServletRequest request) {
		LandmarkFilter filter = new LandmarkFilter();

		if (request.getParameter("cityId") != null) {
			filter.setCityId(request.getParameter("cityId"));
		}

		if (request.getParameter("venueType") != null) {
			filter.setVenueType(request.getParameter("venueType"));
		}

		return filter;
	}
}
