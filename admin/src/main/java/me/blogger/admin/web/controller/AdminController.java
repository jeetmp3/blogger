package me.blogger.admin.web.controller;

import me.blogger.admin.co.BlogCO;
import me.blogger.admin.service.AdminService;
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

	@RequestMapping({"/index", "/list"})
	public String index(Model model) {
		model.addAttribute("blogs", adminService.listBlog());
		return "admin/index";
	}

	@RequestMapping("/create")
	public String create() {
		return "admin/create";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute BlogCO blogCO, Model model) {
		if(ObjectUtils.isEmpty(blogCO)) {
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
