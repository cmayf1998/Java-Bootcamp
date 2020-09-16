package com.techelevator.validation.controller;

import com.techelevator.validation.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
	// GET: /
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getMainScreen() {
		return "homePage";
	}

	// Add the following Controller Actions

	// GET: /register
	// Return the empty registration view
	@RequestMapping(path="/register", method = RequestMethod.GET)
	public String displayRegister(ModelMap modelHolder){
		if (!modelHolder.containsAttribute("register")){
			modelHolder.put("register",new Registration());
		}
		return "register";
	}


	// POST: /register
	// Validate the model and redirect to confirmation (if successful) or return
	// the
	// registration view (if validation fails)

	@RequestMapping(path="/register", method = RequestMethod.POST)
	public String processRegister(@Valid @ModelAttribute Registration register, BindingResult result,
								  RedirectAttributes flash) {
		flash.addFlashAttribute("register",register);
		if (result.hasErrors()){
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "register", result);
			return "redirect:/";
		}

		return "redirect:/confirmation";
	}

	// GET: /login
	// Return the empty login view

	// POST: /login
	// Validate the model and redirect to a confirmation page if validation is
	// successful. Return the login view (if validation fails).

	// GET: /confirmation
	// Return the confirmation view
}
