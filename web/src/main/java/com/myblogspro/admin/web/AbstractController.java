package com.myblogspro.admin.web;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jitendra Singh.
 */
public abstract class AbstractController {

	@Autowired
	HttpServletRequest servletRequest;
	@Autowired
	HttpServletResponse servletResponse;

	public HttpServletRequest request() {
		return servletRequest;
	}

	public HttpServletResponse response() {
		return servletResponse;
	}
}
