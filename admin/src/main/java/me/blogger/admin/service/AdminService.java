package me.blogger.admin.service;

import me.blogger.admin.co.BlogCO;
import me.blogger.admin.dto.BlogDTO;
import me.blogger.admin.security.BloggerUserDetails;
import me.blogger.domains.Blog;
import me.blogger.domains.User;
import me.blogger.repositories.BlogRepository;
import me.blogger.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

	public List<BlogDTO> listBlog() {
		List<Blog> blogs = blogRepository.findAll();
		if (!ObjectUtils.isEmpty(blogs)) {
			return blogs.stream().map(BlogDTO::new).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	public Blog getBlog(String id) {
		return blogRepository.findOne(id);
	}

}
