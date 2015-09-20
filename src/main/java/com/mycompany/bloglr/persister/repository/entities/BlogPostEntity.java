/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.persister.repository.entities;

import java.util.Date;

import javax.persistence.CascadeType;
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
 * {@link BlogPostEntity} 
 * 
 * @author colin
 *
 */
@Entity
@Table(name = "blog_post")
public class BlogPostEntity {

	private int blogPostId;
	private String blogTitle;
	private String blogContent;
	private Date createdDate;
	private BlogUserEntity author;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getBlogPostId() {
		return blogPostId;
	}
	
	public void setBlogPostId(int blogPostId) {
		this.blogPostId = blogPostId;
	}
	
	@Column(name = "title", length = 100)
	public String getBlogTitle() {
		return blogTitle;
	}
	
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	
	@Column(name = "content", columnDefinition = "TEXT")
	public String getBlogContent() {
		return blogContent;
	}
	
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinColumn(name = "author")
	public BlogUserEntity getAuthor() {
		return author;
	}
	
	public void setAuthor(BlogUserEntity author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "BlogPostEntity [blogPostId=" + blogPostId + ", blogTitle=" + blogTitle + ", blogContent=" + blogContent
				+ ", createdDate=" + createdDate + ", author=" + author + "]";
	}
	
}
