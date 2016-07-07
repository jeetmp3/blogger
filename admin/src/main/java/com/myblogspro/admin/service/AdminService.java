package com.myblogspro.admin.service;

import com.myblogspro.admin.co.BlogCO;
import com.myblogspro.admin.dto.BlogDTO;
import com.myblogspro.admin.security.BloggerUserDetails;
import com.myblogspro.domains.Blog;
import com.myblogspro.domains.User;
import com.myblogspro.repositories.BlogRepository;
import com.myblogspro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Jitendra Singh.
 */
@Service
public class AdminService {

	@Autowired
	BlogRepository blogRepository;
	@Autowired
	SpringSecurityService springSecurityService;
	@Autowired
	UserRepository userRepository;

	public void saveBlog(BlogCO blogCO) {
		Optional<UserDetails> userDetails = springSecurityService.getUserDetails();
		if (userDetails.isPresent()) {
			BloggerUserDetails bloggerUserDetails = (BloggerUserDetails) userDetails.get();
			User user = userRepository.findOne(bloggerUserDetails.getId());
			Blog blog = new Blog().setTitle(blogCO.getTitle())
					.setAuthor(user)
					.setContent(blogCO.getContent())
					.setDescription(blogCO.getDescription())
					.setDateCreated(LocalDateTime.now())
					.setActive(true);
			blogRepository.save(blog);
		}
	}

	public List<BlogDTO> listMyBlog(User user) {
		Page<Blog> blogs = null;
		if(ObjectUtils.isEmpty(user)) {
			blogs = blogRepository.findAll(new PageRequest(0, 10));
		} else {
			blogs = blogRepository.findAllByAuthor(user, new PageRequest(0, 10));
		}
		if (!ObjectUtils.isEmpty(blogs)) {
			return blogs.getContent().stream().map(BlogDTO::new).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	public List<BlogDTO> listBlog() {
		return listMyBlog(null);
	}

	public Blog getBlog(String id) {
		return blogRepository.findOne(id);
	}

}
