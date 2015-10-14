/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.bloglr.blogengine.BlogEngine;
import com.mycompany.bloglr.domain.dto.BlogPostDto;

/**
 * {@link Controller} 
 * 
 * @author colin
 *
 */
@Named("controller")
public class Controller {

	private static final Logger logger = LoggerFactory.getLogger(Controller.class);
	
	@Inject
	private BlogEngine blogEngine;
	
	public void addBlogPost(BlogPostDto blogPostDto) {
		logger.info("Adding new blog post: " + blogPostDto);
		blogEngine.addBlogPost(blogPostDto);
	}
	
	public void deleteBlogPost(BlogPostDto blogPostDto) {
		logger.info("Deleting blog post: " + blogPostDto);
		blogEngine.deleteBlogPost(blogPostDto);
	}
	
	public void editBlogPost(BlogPostDto blogPostDto) {
		logger.info("Edit blog post: " + blogPostDto);
		blogEngine.editBlogPost(blogPostDto);
	}
}
