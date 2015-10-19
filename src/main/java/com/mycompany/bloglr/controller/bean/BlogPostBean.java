/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.controller.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.mycompany.bloglr.blogengine.domain.BlogComment;

/**
 * {@link BlogPostBean} 
 * 
 * @author colin
 *
 */
@ManagedBean
@SessionScoped
public class BlogPostBean {

	private int blogPostId;
	private String blogPostTitle;
	private String blogPostContent;
	private List<BlogComment> blogPostComments = new ArrayList<>();
	
	public BlogPostBean() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		blogPostId = Integer.parseInt(params.get("blogPostId"));
		
		// get stub data
		blogPostTitle = "Title";
		blogPostContent = "Content";
		for(int i = 1; i < 5; i++) {
			BlogComment blogComment = new BlogComment();
			blogComment.setContent("Comment");
			blogPostComments.add(blogComment);
		}
	}
	
	public int getBlogPostId() {
		return blogPostId;
	}

	public void setBlogPostId(int blogPostId) {
		this.blogPostId = blogPostId;
	}

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

	public List<BlogComment> getBlogPostComments() {
		return blogPostComments;
	}

	public void setBlogPostComments(List<BlogComment> blogPostComments) {
		this.blogPostComments = blogPostComments;
	}
	
	
}
