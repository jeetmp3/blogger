package me.blogger.domains;

/**
 * @author Jitendra Singh.
 */
public class Blog extends AbstractDomain<Blog> {

	private String title;
	private String description;
	private String content;

	public String getTitle() {
		return title;
	}

	public Blog setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Blog setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getContent() {
		return content;
	}

	public Blog setContent(String content) {
		this.content = content;
		return this;
	}
}
