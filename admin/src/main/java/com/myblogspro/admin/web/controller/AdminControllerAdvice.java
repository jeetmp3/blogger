package com.myblogspro.admin.web.controller;

import com.myblogspro.admin.service.SpringSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Optional;

/**
 * @author Jitendra Singh.
 */
@ControllerAdvice("com.myblogspro.admin.web.controller")
public class AdminControllerAdvice {

	private final static String CURRENT_USER = "CURRENT_USER";

	@Autowired
	SpringSecurityService springSecurityService;

	@ModelAttribute
	public void globalModelAttributes(Model model) {
		if (springSecurityService.isLoggedIn()) {
			Optional<UserDetails> userDetails = springSecurityService.getUserDetails();
			if (userDetails.isPresent()) {
				model.addAttribute(CURRENT_USER, userDetails.get());
			}
		}
	}
}
