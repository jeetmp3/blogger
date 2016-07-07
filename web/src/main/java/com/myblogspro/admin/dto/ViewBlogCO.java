package com.myblogspro.admin.dto;

/**
 * @author Jitendra Singh.
 */
public class ViewBlogCO {

	private String username;
	private short year;
	private byte month;
	private byte day;
	private String title;

	public String getUsername() {
		return username;
	}

	public ViewBlogCO setUsername(String username) {
		this.username = username;
		return this;
	}

	public short getYear() {
		return year;
	}

	public ViewBlogCO setYear(short year) {
		this.year = year;
		return this;
	}

	public byte getMonth() {
		return month;
	}

	public ViewBlogCO setMonth(byte month) {
		this.month = month;
		return this;
	}

	public byte getDay() {
		return day;
	}

	public ViewBlogCO setDay(byte day) {
		this.day = day;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public ViewBlogCO setTitle(String title) {
		this.title = title;
		return this;
	}
}
