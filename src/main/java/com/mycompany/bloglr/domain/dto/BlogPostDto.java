/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.domain.dto;

import java.time.LocalDateTime;

/**
 * 
 * @author colin
 *
 */
public class BlogPostDto {

	private int postId;
	private String title;
	private String content;
	private LocalDateTime dateCreated;

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
