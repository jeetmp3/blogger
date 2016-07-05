package me.blogger.admin.web;

import me.blogger.admin.co.PageableCO;
import me.blogger.admin.dto.ViewBlogCO;
import me.blogger.admin.services.BlogService;
import me.blogger.domains.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static me.blogger.admin.constants.AppConstants.*;

/**
 * @author Jitendra Singh.
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	BlogService blogService;

	@RequestMapping({"/index", SYMBOL_FORWARD_SLASH})
	public String index(PageableCO pageableCO, Model model) {
		List<Blog> latestBlogs = blogService.latestBlogs(pageableCO);
		model.addAttribute(BLOGS, latestBlogs);
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
		modelAndView.addObject("blog", blog);
		return modelAndView;
	}

	@RequestMapping("/{username}")
	public ModelAndView view(@PathVariable("username") String username, @ModelAttribute PageableCO pageableCO) {
		ModelAndView modelAndView = new ModelAndView("blog/userBlogs");
		List<Blog> latestBlogs = blogService.latestBlogs(username, pageableCO);
		modelAndView.addObject(BLOGS, latestBlogs);
		return modelAndView;
	}
}
