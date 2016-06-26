package me.blogger.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jitendra Singh.
 */
@Controller
@RequestMapping({"/home", "/"})
public class HomeController extends AbstractController {

	@RequestMapping("/index")
	public String index(String view) {
		return "layouts/main";
	}
}
