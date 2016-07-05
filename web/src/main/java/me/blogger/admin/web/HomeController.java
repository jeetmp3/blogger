//package me.blogger.admin.web;
//
//import me.blogger.admin.co.PageableCO;
//import me.blogger.admin.services.BlogService;
//import me.blogger.domains.Blog;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//import static me.blogger.admin.constants.AppConstants.*;
//
///**
// * @author Jitendra Singh.
// */
//@Controller
//@RequestMapping({"/home", SYMBOL_FORWARD_SLASH})
//public class HomeController extends AbstractController {
//
//	@Autowired
//	BlogService blogService;
//
//	@RequestMapping({"/index", SYMBOL_FORWARD_SLASH})
//	public String index(PageableCO pageableCO, Model model) {
//		List<Blog> latestBlogs = blogService.latestBlogs(pageableCO);
//		model.addAttribute(BLOGS, latestBlogs);
//		return "home/index";
//	}
//}
