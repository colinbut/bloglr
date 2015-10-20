/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.blogengine.domain;

import java.time.LocalDateTime;

/**
 * @author colin
 *
 */
public class BlogPostComment {
	
	private String comment;
	private LocalDateTime commentCreated;
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public LocalDateTime getCommentCreated() {
		return commentCreated;
	}
	
	public void setCommentCreated(LocalDateTime commentCreated) {
		this.commentCreated = commentCreated;
	}

	@Override
	public String toString() {
		return "BlogPostComment [comment=" + comment + ", commentCreated=" + commentCreated + "]";
	}
	
}
