package me.blogger.domains;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

/**
 * @author Jitendra Singh.
 */
@CompoundIndexes({
		@CompoundIndex(def = "{'author': 1, 'titleLink': 1, 'year': 1, 'month': 1, 'day': 1}",
				name = "author_titleLink_year_month_day", unique = true)
})
public class Blog extends AbstractDomain<Blog> {

	@DBRef
	private User author;
	private String title;
	private String titleLink;
	private String description;
	private String content;
	private short year;
	private byte month;
	private byte day;

	public User getAuthor() {
		return author;
	}

	public Blog setAuthor(User author) {
		this.author = author;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Blog setTitle(String title) {
		this.title = title;
		this.titleLink = ObjectUtils.isEmpty(title) ? title : title.replaceAll(" ", "-");
		return this;
	}

	public String getTitleLink() {
		return titleLink;
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

	public short getYear() {
		return year;
	}

	public Blog setYear(short year) {
		this.year = year;
		return this;
	}

	public byte getMonth() {
		return month;
	}

	public Blog setMonth(byte month) {
		this.month = month;
		return this;
	}

	public byte getDay() {
		return day;
	}

	public Blog setDay(byte day) {
		this.day = day;
		return this;
	}

	@Override
	public Blog setDateCreated(LocalDateTime dateCreated) {
		super.setDateCreated(dateCreated);
		setYear((short) dateCreated.getYear());
		setMonth((byte) dateCreated.getMonth().getValue());
		setDay((byte) dateCreated.getDayOfMonth());
		return this;
	}
}
