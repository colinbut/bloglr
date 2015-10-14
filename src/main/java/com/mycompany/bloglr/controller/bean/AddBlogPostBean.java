/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.controller.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.bloglr.controller.Controller;
import com.mycompany.bloglr.domain.dto.BlogPostDto;

/**
 * {@link AddBlogPostBean} 
 * 
 * @author colin
 *
 */
@ManagedBean
@RequestScoped
public class AddBlogPostBean {

	private static final Logger logger = LoggerFactory.getLogger(AddBlogPostBean.class);
	
	@Inject
	private Controller controller;
	
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
		BlogPostDto blogPostDto = new BlogPostDto();
		blogPostDto.setTitle(blogPostTitle);
		blogPostDto.setContent(blogPostContent);
		controller.addBlogPost(blogPostDto);
		return null;
	}
}
