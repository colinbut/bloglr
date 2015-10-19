/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.bloglr.blogengine.BlogEngine;
import com.mycompany.bloglr.common.annotation.Controller;
import com.mycompany.bloglr.controller.dto.BlogPostDto;

/**
 * {@link BlogController} 
 * 
 * @author colin
 *
 */
@Controller
public class BlogController {

	private static final Logger logger = LoggerFactory.getLogger(BlogController.class);
	
	@Inject
	private BlogEngine blogEngine;
	
	/**
	 * Adds a new blog post
	 * 
	 * @param blogPostDto
	 */
	public void addBlogPost(BlogPostDto blogPostDto) {
		logger.info("Adding new blog post: " + blogPostDto);
		blogEngine.addBlogPost(blogPostDto);
	}
	
	/**
	 * Deletes an existing blog post
	 * 
	 * @param blogPostDto
	 */
	public void deleteBlogPost(BlogPostDto blogPostDto) {
		logger.info("Deleting blog post: " + blogPostDto);
		blogEngine.deleteBlogPost(blogPostDto);
	}
	
	/**
	 * Edit an existing blog post
	 * 
	 * @param blogPostDto
	 */
	public void editBlogPost(BlogPostDto blogPostDto) {
		logger.info("Edit blog post: " + blogPostDto);
		blogEngine.editBlogPost(blogPostDto);
	}
}
