package me.blogger.admin.web.controller;

import me.blogger.admin.service.SpringSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jitendra Singh.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	SpringSecurityService springSecurityService;

	@RequestMapping("/auth")
	public String auth() {
		if(springSecurityService.isLoggedIn()) {

		}
		return "login/auth";
	}

	@RequestMapping("/register")
	public String register() {
		return "login/register";
	}
}
