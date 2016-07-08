package com.myblogspro.admin.web.controller;

import com.myblogspro.admin.co.BlogCO;
import com.myblogspro.admin.security.BloggerUserDetails;
import com.myblogspro.admin.service.AdminService;
import com.myblogspro.admin.service.SpringSecurityService;
import com.myblogspro.domains.User;
import com.myblogspro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Jitendra Singh.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	@Autowired
	SpringSecurityService springSecurityService;
	@Autowired
	UserRepository userRepository;

	@RequestMapping({"/index", "/list"})
	public String index(Model model) {
		BloggerUserDetails userDetails = (BloggerUserDetails) springSecurityService.getUserDetails().get();
		User user = userRepository.findOne(userDetails.getId());
		model.addAttribute("blogs", adminService.listMyBlog(user));
		return "admin/index";
	}

	@RequestMapping("/create")
	public String create() {
		return "admin/create";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute BlogCO blogCO) {
		if (ObjectUtils.isEmpty(blogCO)) {
			return "admin/create";
		} else {
			adminService.saveBlog(blogCO);
			return "redirect:/admin/index";
		}
	}

	@RequestMapping("/view")
	public String view(String id, Model model) {
		model.addAttribute("blog", adminService.getBlog(id));
		return "admin/view";
	}
}
