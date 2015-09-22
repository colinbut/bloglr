/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link AddBlogPostBean} 
 * 
 * @author colin
 *
 */
@ManagedBean
@RequestScoped
public class AddBlogPostBean {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	private String blogPostTitle;
	private String blogPostContent;
	
	public String getBlogPostTitle() {
		return blogPostTitle;
	}

	public void setBlogPostTitle(String blogPostTitle) {
		this.blogPostTitle = blogPostTitle;
	}
	
	public String getBlogPostContent() {
		return blogPostContent;
	}

	public void setBlogPostContent(String blogPostContent) {
		this.blogPostContent = blogPostContent;
	}

	public String addBlogPost() {
		logger.info("Adding new blog post: ");
		return null;
	}
}
