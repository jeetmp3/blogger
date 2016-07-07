package com.myblogspro.admin.web;

import com.myblogspro.admin.co.PageableCO;
import com.myblogspro.admin.services.BlogService;
import com.myblogspro.admin.dto.ViewBlogCO;
import com.myblogspro.domains.Blog;
import com.myblogspro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.myblogspro.admin.constants.AppConstants.*;

/**
 * @author Jitendra Singh.
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	BlogService blogService;
	@Autowired
	UserRepository userRepository;

	@RequestMapping({"/index", SYMBOL_FORWARD_SLASH})
	public String index(PageableCO pageableCO, Model model) {
		Page<Blog> latestBlogs = blogService.latestBlogs(pageableCO);
		model.addAttribute(BLOGS, latestBlogs);
		model.addAttribute(PAGINATION, pageableCO);
		return "blog/index";
	}

	@RequestMapping("/{username}/{year}/{month}/{day}/{title}")
	public ModelAndView view(@PathVariable("username") String username, @PathVariable("year") short year,
	                         @PathVariable("month") byte month, @PathVariable("day") byte day,
	                         @PathVariable("title") String title) {
		ViewBlogCO blogCO = new ViewBlogCO().setUsername(username).setYear(year).setMonth(month)
				.setDay(day).setTitle(title);
		Blog blog = blogService.fetchBlog(blogCO);
		ModelAndView modelAndView = new ModelAndView("blog/view");
		modelAndView.addObject(USER, userRepository.findByUsernameAndActive(username, true));
		modelAndView.addObject("blog", blog);
		return modelAndView;
	}

	@RequestMapping("/{username}")
	public ModelAndView view(@PathVariable("username") String username, @ModelAttribute PageableCO pageableCO) {
		ModelAndView modelAndView = new ModelAndView("blog/userBlogs");
		Page<Blog> latestBlogs = blogService.latestBlogs(username, pageableCO);
		modelAndView.addObject(PAGINATION, pageableCO);
		modelAndView.addObject(USER, userRepository.findByUsernameAndActive(username, true));
		modelAndView.addObject(BLOGS, latestBlogs);
		return modelAndView;
	}
}
