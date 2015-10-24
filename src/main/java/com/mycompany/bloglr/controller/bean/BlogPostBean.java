/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.controller.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.mycompany.bloglr.blogengine.domain.BlogPostComment;
import com.mycompany.bloglr.controller.BlogController;
import com.mycompany.bloglr.controller.dto.BlogPostCommentDto;
import com.mycompany.bloglr.controller.dto.BlogPostDto;

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
	private List<BlogPostCommentDto> blogPostComments = new ArrayList<>();
	
	@Inject
	private BlogController controller;
	
	/**
	 * Constructor
	 */
	public BlogPostBean() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		blogPostId = Integer.parseInt(params.get("blogPostId"));
		
	}
	
	@PostConstruct
	private void init() {
		BlogPostDto blogPostDto = controller.getBlogPost(blogPostId);
		blogPostTitle = blogPostDto.getTitle();
		blogPostContent = blogPostDto.getContent();
		
		blogPostComments = blogPostDto.getBlogPostComments();
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

	public List<BlogPostCommentDto> getBlogPostComments() {
		return blogPostComments;
	}

	public void setBlogPostComments(List<BlogPostCommentDto> blogPostComments) {
		this.blogPostComments = blogPostComments;
	}
	
	
}
