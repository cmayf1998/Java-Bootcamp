package com.techelevator.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.techelevator.dao.ItineraryDAO;
import com.techelevator.dao.LandmarkDAO;
import com.techelevator.entity.Itinerary;
import com.techelevator.entity.Landmark;
import com.techelevator.entity.User;
import com.techelevator.security.AuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import java.util.List;

@Controller
public class ItineraryController {

	@Autowired
	private ItineraryDAO itineraryDAO;

	@Autowired
	private LandmarkDAO landmarkDAO;

	@RequestMapping(path="/itineraryForm", method=RequestMethod.GET)
	public String displayCreateItineraryForm(ModelMap modelHolder,
											 HttpServletRequest request) {
		String itineraryIdStr = request.getParameter("itineraryId");
		if (!modelHolder.containsAttribute("itinerary")) {
			Itinerary itinerary = null;
			if (itineraryIdStr == null){
				itinerary = new Itinerary();
			} else {
				int itineraryId = Integer.parseInt(itineraryIdStr);
				itinerary = itineraryDAO.getItineraryById(itineraryId);
			}
			modelHolder.put("itinerary", itinerary);
		}

		return "view/itineraryForm";
	}

	@RequestMapping(path = "/itineraryForm", method = RequestMethod.POST)
	public String processItinerary(
			@Valid @ModelAttribute Itinerary itinerary,
			BindingResult result,
			HttpSession session,
			RedirectAttributes flash) {

		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "itinerary", result);
			return "redirect:/itineraryForm";
		}

		if(itinerary.getItineraryId() == 0){
			Long userId = ( (User)session.getAttribute(AuthorizationFilter.LOGGED_USER) ).getId();
			itineraryDAO.addItinerary(itinerary, userId);
		}else {
			itineraryDAO.editItinerary(itinerary);
		}

		return "redirect:/user/itinerary";
	}

	@RequestMapping(path = "/deleteItinerary", method = RequestMethod.POST)
	public String processDeleteItinerary(
			@RequestParam int itineraryId) {

		itineraryDAO.deleteItinerary(itineraryId);

		return "redirect:/user/itinerary";
	}

	//Generate Travel Route:
	@RequestMapping(path = "/showItineraryDestinations", method = RequestMethod.GET)
	public String showItineraryDestinations(HttpServletRequest request,
										   @RequestParam int itineraryId) {

		List <Landmark> landmarks = itineraryDAO.getAllLandmarksForItineraryId(itineraryId);
		request.setAttribute("landmarks", landmarks);

		return "view/showItineraryDestinations";
	}

	//Generate Directions:
	@RequestMapping(path = "/showTravelRoute", method = RequestMethod.GET)
	public RedirectView generateTravelMap(ModelMap modelHolder, @RequestParam int itineraryId) {
		List <Landmark> landmarkList = itineraryDAO.getAllLandmarksForItineraryId(itineraryId);
		String url = getGoogleMapUrl(landmarkList);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(url);

		return redirectView;
	}

	public String getGoogleMapUrl(List<Landmark> landmarkList) {

		String mapLink = "https://www.google.com/maps/dir/";
		for (Landmark landmark : landmarkList) {
			String landmarkAddress = landmark.getAddress();
			String parsedAddress = landmarkAddress.replaceAll(" ", "+");
			System.out.println(parsedAddress);

			mapLink += parsedAddress + "/";
		}
		return mapLink;

	}
}
