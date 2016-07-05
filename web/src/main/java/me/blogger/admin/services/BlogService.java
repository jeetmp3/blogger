package me.blogger.admin.services;

import me.blogger.admin.co.PageableCO;
import me.blogger.admin.dto.ViewBlogCO;
import me.blogger.domains.Blog;
import me.blogger.domains.User;
import me.blogger.repositories.BlogRepository;
import me.blogger.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
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

	public List<Blog> latestBlogs(PageableCO pageableCO) {
		return latestBlogs(null, pageableCO);
	}

	public List<Blog> latestBlogs(String author, PageableCO pageableCO) {
		Pageable pageable = new PageRequest(pageableCO.getPage(), pageableCO.getMax(),
				new Sort(Sort.Direction.DESC, "dateCreated"));
		User user = userRepository.findByUsernameAndActive(author, true);
		if(!ObjectUtils.isEmpty(user)) {
			Page<Blog> page = blogRepository.findAllByAuthor(user, pageable);
			return page.getContent();
		} else {
			Page<Blog> page = blogRepository.findAll(pageable);
			return page.getContent();
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
