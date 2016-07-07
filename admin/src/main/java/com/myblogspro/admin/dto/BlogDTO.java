package com.myblogspro.admin.dto;

import com.myblogspro.domains.Blog;

import java.time.LocalDateTime;

/**
 * @author Jitendra Singh.
 */
public class BlogDTO {

	private String id;
	private String title;
	private String description;
	private LocalDateTime dateCreated;

	public BlogDTO(Blog blog) {
		this.id = blog.getId();
		this.title = blog.getTitle();
		this.description = blog.getDescription();
		this.dateCreated = blog.getDateCreated();
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
}
