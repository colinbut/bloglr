/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.controller.dto;

import java.time.LocalDateTime;

/**
 * 
 * @author colin
 *
 */
public class BlogPostCommentDto {

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
	
	
}
