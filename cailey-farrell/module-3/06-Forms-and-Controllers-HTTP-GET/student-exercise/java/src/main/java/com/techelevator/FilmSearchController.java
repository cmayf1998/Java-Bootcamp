package com.techelevator;

import com.techelevator.dao.FilmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FilmSearchController
 */
@Controller
public class FilmSearchController {

    @Autowired
    FilmDao filmDao;

    @RequestMapping("/searchFilmsForm")

    public String showFilmSearchForm() {

        return "filmList";
    }


@RequestMapping("/searchFilms")
    public String searchFilms(
            @RequestParam int minLength,
            @RequestParam int maxLength,
            @RequestParam String category,
            ModelMap modelMap

) {

    modelMap.put("films", filmDao.getFilmsBetween(category, minLength, maxLength));
    return "filmList";
}

}