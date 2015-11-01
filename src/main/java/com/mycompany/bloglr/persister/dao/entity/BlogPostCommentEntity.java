/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.persister.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author colin
 *
 */
@Entity
@Table(name = "blog_post_comment")
public class BlogPostCommentEntity {

	private int id;
	private String comment;
	private Date commentCreatedDate;
	
	private BlogPostEntity blogPost;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "comment", nullable = false, columnDefinition = "TEXT")
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Column(name = "comment_created_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCommentCreatedDate() {
		return commentCreatedDate;
	}

	public void setCommentCreatedDate(Date commentCreatedDate) {
		this.commentCreatedDate = commentCreatedDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "blog_post_id", nullable = false)
	public BlogPostEntity getBlogPost() {
		return blogPost;
	}

	public void setBlogPost(BlogPostEntity blogPostEntity) {
		this.blogPost = blogPostEntity;
		//blogPostEntity.getBlogPostComments().add(this);
	}

	@Override
	public String toString() {
		return "BlogPostCommentEntity [id=" + id + ", comment=" + comment + "]";
	}
	
}
