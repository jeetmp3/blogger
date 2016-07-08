package com.myblogspro.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jitendra Singh.
 */
@Controller
@RequestMapping("/search")
public class SearchController {

	@RequestMapping("{keywords}")
	public String search(@PathVariable String keywords) {
		return "search/result";
	}
}
