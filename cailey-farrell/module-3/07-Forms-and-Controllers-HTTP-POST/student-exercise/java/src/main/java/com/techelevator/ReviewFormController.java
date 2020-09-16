package com.techelevator;

import com.techelevator.model.Review;
import com.techelevator.model.ReviewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReviewFormController {

    @Autowired
    private ReviewDao reviewDao;


    @RequestMapping(path = "/reviewInput", method = RequestMethod.GET)
    public String showReviewInput() {
        return "reviewInput";
    }

    @RequestMapping(path = "/reviewInput", method = RequestMethod.POST)
    public String processReviewInput(Review review) {

        // here we do something useful with the survey object

        reviewDao.save(review);

        return "redirect:/";
    }

}

