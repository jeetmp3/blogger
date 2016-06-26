package me.blogger.admin.service;

import me.blogger.admin.co.BlogCO;
import me.blogger.admin.dto.BlogDTO;
import me.blogger.domains.Blog;
import me.blogger.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jitendra Singh.
 */
@Service
public class AdminService {

	@Autowired
	BlogRepository blogRepository;

	public void saveBlog(BlogCO blogCO) {
		Blog blog = new Blog().setTitle(blogCO.getTitle())
				.setContent(blogCO.getContent())
				.setDescription(blogCO.getDescription())
				.setDateCreated(LocalDateTime.now())
				.setActive(true);
		blogRepository.save(blog);
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
