package me.blogger.admin.service;

import me.blogger.admin.co.BlogCO;
import me.blogger.admin.dto.BlogDTO;
import me.blogger.domains.Blog;
import me.blogger.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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
				.setDateCreated(new Date())
				.setActive(true);
		blogRepository.save(blog);
	}

	public List<BlogDTO> listBlog() {
		List<Blog> blogs = blogRepository.findAll();
		if (!ObjectUtils.isEmpty(blogs)) {
			List<BlogDTO> blogDTOs = new ArrayList<>();
			for(Blog blog : blogs) {
				blogDTOs.add(new BlogDTO(blog));
			}
			return blogDTOs;
		}
		return Collections.emptyList();
	}

	public Blog getBlog(String id) {
		return blogRepository.findOne(id);
	}

}
