package com.myblogspro.admin.co;

import org.springframework.util.ObjectUtils;

import static com.myblogspro.constants.CoreConstants.EMPTY_STRING;

/**
 * @author Jitendra Singh.
 */
public class BlogCO {

	private String title;
	private String description;
	private String content;
	private String tags;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTags() {
		return ObjectUtils.isEmpty(tags) ? EMPTY_STRING : tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
}
