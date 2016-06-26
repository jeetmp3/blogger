package me.blogger.admin.web.controller;

import me.blogger.admin.service.SpringSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author Jitendra Singh.
 */
@ControllerAdvice("me.blogger.admin.web.controller")
public class AdminControllerAdvice {

	private final static String CURRENT_USER = "CURRENT_USER";

	@Autowired
	SpringSecurityService springSecurityService;

	@ModelAttribute
	public void globalModelAttributes(Model model) {
		if (springSecurityService.isLoggedIn()) {
			UserDetails userDetails = springSecurityService.getUserDetails();
			if (!ObjectUtils.isEmpty(userDetails)) {
				model.addAttribute(CURRENT_USER, userDetails);
			}
		}
	}
}
