/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.blogengine.domain;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author colin
 *
 */
public class BlogPost {

	private int postId;
	private String title;
	private Author author;
	private LocalDateTime dateCreated;
	private LocalDateTime dateUpdated;
	private String content;
	private List<BlogComment> comments;
	
	private boolean editable;
	
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public LocalDateTime getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(LocalDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<BlogComment> getComments() {
		return comments;
	}
	public void setComments(List<BlogComment> comments) {
		this.comments = comments;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	@Override
	public String toString() {
		return "BlogPost [postId=" + postId + ", title=" + title + ", author=" + author + ", dateCreated=" + dateCreated
				+ ", dateUpdated=" + dateUpdated + ", content=" + content + ", comments=" + comments + "]";
	}
	
	
	
	
}
