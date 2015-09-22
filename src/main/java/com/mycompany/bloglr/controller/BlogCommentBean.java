/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author colin
 *
 */
@ManagedBean
@SessionScoped
public class BlogCommentBean {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	private String blogComment;

	public String getBlogComment() {
		return blogComment;
	}

	public void setBlogComment(String blogComment) {
		this.blogComment = blogComment;
	}
	
	public String addBlogComment() {
		logger.info("Adding blog comment: " + blogComment);
		return null;
	}
}
