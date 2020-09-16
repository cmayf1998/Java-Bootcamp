package com.techelevator.controller;

import com.techelevator.model.FavoriteThings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/FavoriteThings")
public class FavoriteThingsController {

	@RequestMapping(path = "/Page1", method = RequestMethod.GET)
	public String getPage1() {

		return "page1";
	}

	@RequestMapping(path = "/Page1", method = RequestMethod.POST)
	public String processPersonalInformationInput(
			@RequestParam String favoriteColor, HttpSession session) {
		FavoriteThings favoriteThings = new FavoriteThings();
		favoriteThings.setColor(favoriteColor);

		session.setAttribute("favorites", favoriteThings);

		return "redirect:/FavoriteThings/Page2";
	}

	@RequestMapping(path = "/Page2", method = RequestMethod.GET)
	public String getPage2(HttpSession session){

		return "page2";
	}
	@RequestMapping(path = "/Page2", method = RequestMethod.POST)
	public String processPage2(
			@RequestParam String favoriteFood, HttpSession session) {

		FavoriteThings favoriteThings = (FavoriteThings)session.getAttribute("favorites");
		favoriteThings.setFood(favoriteFood);

		return "redirect:/FavoriteThings/Page3";
	}

	@RequestMapping(path = "/Page3", method = RequestMethod.GET)
	public String getPage3(HttpSession session){

		return "page3";
	}
	@RequestMapping(path = "/Page3", method = RequestMethod.POST)
	public String processPage3(
			@RequestParam String favoriteSeason, HttpSession session) {

		FavoriteThings favoriteThings = (FavoriteThings)session.getAttribute("favorites");
		favoriteThings.setSeason(favoriteSeason);

		return "redirect:/FavoriteThings/Summary";
	}

	@RequestMapping(path = "/Summary", method = RequestMethod.GET)
	public String processApplication(HttpSession session){

		FavoriteThings favoriteThings = (FavoriteThings) session.getAttribute("favorites");
		return "summary";
	}
}
