package com.myblogspro.admin.web.controller;

import com.myblogspro.admin.security.BloggerUserDetails;
import com.myblogspro.admin.service.SpringSecurityService;
import com.myblogspro.domains.User;
import com.myblogspro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * @author Jitendra Singh.
 */
@Controller
@RequestMapping("/admin/profile")
public class AdminProfileController {

	@Autowired
	SpringSecurityService springSecurityService;
	@Autowired
	UserRepository userRepository;

	@RequestMapping("/view")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("adminProfile/view");
		Optional<UserDetails> userDetails = springSecurityService.getUserDetails();
		if (userDetails.isPresent()) {
			BloggerUserDetails bloggerUserDetails = (BloggerUserDetails) userDetails.get();
			User user = userRepository.findOne(bloggerUserDetails.getId());
			modelAndView.addObject("user", user);
		}
		return modelAndView;
	}

	@RequestMapping("/edit")
	public ModelAndView profileEdit() {
		ModelAndView modelAndView = new ModelAndView("adminProfile/edit");
		Optional<UserDetails> userDetails = springSecurityService.getUserDetails();
		if (userDetails.isPresent()) {
			BloggerUserDetails bloggerUserDetails = (BloggerUserDetails) userDetails.get();
			User user = userRepository.findOne(bloggerUserDetails.getId());
			modelAndView.addObject("user", user);
		}
		return modelAndView;
	}
}
