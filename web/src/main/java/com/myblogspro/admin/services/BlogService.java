package com.myblogspro.admin.services;

import com.myblogspro.admin.co.PageableCO;
import com.myblogspro.admin.dto.ViewBlogCO;
import com.myblogspro.domains.Blog;
import com.myblogspro.domains.User;
import com.myblogspro.repositories.BlogRepository;
import com.myblogspro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author Jitendra Singh.
 */
@Service
public class BlogService {

	@Autowired
	BlogRepository blogRepository;
	@Autowired
	UserRepository userRepository;

	public Page<Blog> latestBlogs(PageableCO pageableCO) {
		return latestBlogs(null, pageableCO);
	}

	public Page<Blog> latestBlogs(String author, PageableCO pageableCO) {
		Pageable pageable = new PageRequest(pageableCO.getPage(), pageableCO.getMax(),
				new Sort(Sort.Direction.DESC, "dateCreated"));
		User user = userRepository.findByUsernameAndActive(author, true);
		if (!ObjectUtils.isEmpty(user)) {
			return blogRepository.findAllByAuthor(user, pageable);
		} else {
			return blogRepository.findAll(pageable);
		}
	}

	public Blog fetchBlog(ViewBlogCO blogCO) {
		User user = userRepository.findByUsernameAndActive(blogCO.getUsername(), true);
		if (!ObjectUtils.isEmpty(user)) {
			return blogRepository.findByAuthorAndTitleLinkAndYearAndMonthAndDay(
					user, blogCO.getTitle(), blogCO.getYear(), blogCO.getMonth(), blogCO.getDay()
			);
		}
		return null;
	}
}
