/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Viewmodel DTO for Blog Post
 *
 * @author colin
 *
 */
public class BlogPostDto {

	private int postId;
	private String title;
	private String content;
	private LocalDateTime dateCreated;
	
	private List<BlogPostCommentDto> blogPostComments = new ArrayList<>();

	private boolean editable;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public List<BlogPostCommentDto> getBlogPostComments() {
		return blogPostComments;
	}

	public void setBlogPostComments(List<BlogPostCommentDto> blogPostComments) {
		this.blogPostComments = blogPostComments;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	@Override
	public String toString() {
		return "BlogPostDto [postId=" + postId + ", title=" + title + ", content=" + content + ", dateCreated="
				+ dateCreated + ", editable=" + editable + "]";
	}
		
}
