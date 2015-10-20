/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.controller.bean;

import java.time.LocalDateTime;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.bloglr.controller.BlogController;
import com.mycompany.bloglr.controller.dto.BlogPostCommentDto;

/**
 * @author colin
 *
 */
@ManagedBean
@SessionScoped
public class BlogCommentBean {

	private static final Logger logger = LoggerFactory.getLogger(BlogCommentBean.class);
	
	@Inject
	private BlogController controller;
	
	private String blogComment;

	public String getBlogComment() {
		return blogComment;
	}

	public void setBlogComment(String blogComment) {
		this.blogComment = blogComment;
	}
	
	public String addBlogComment(int blogPostId) {
		logger.info("Adding blog comment: " + blogComment + " for blog: " + blogPostId);
		
		BlogPostCommentDto blogPostCommentDto = new BlogPostCommentDto();
		blogPostCommentDto.setComment(blogComment);
		blogPostCommentDto.setCommentCreated(LocalDateTime.now());
		
		controller.addBlogPostComment(blogPostCommentDto);
		
		return null;// return to same page with updated info
	}
}
