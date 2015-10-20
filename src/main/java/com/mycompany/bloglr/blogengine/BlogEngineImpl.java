/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.blogengine;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.bloglr.blogengine.domain.BlogPostComment;
import com.mycompany.bloglr.blogengine.domain.BlogPost;
import com.mycompany.bloglr.common.annotation.DataAccess;
import com.mycompany.bloglr.controller.dto.BlogPostDto;
import com.mycompany.bloglr.persister.Persister;
import com.mycompany.bloglr.persister.dao.entity.BlogPostCommentEntity;
import com.mycompany.bloglr.persister.dao.entity.BlogPostEntity;

/**
 * Implementation of {@link BlogEngine} interface
 * 
 * @author colin
 *
 */
@Model
public class BlogEngineImpl implements BlogEngine {

	private static final Logger logger = LoggerFactory.getLogger(BlogEngineImpl.class);
	
	@Inject
	private Persister persister;
	
	private List<BlogPost> blogPosts = new ArrayList<>();
	
	/**
	 * Constructor
	 */
	public BlogEngineImpl() {
		
	}
	
	private void loadBlogPosts() {
		// load from db
		
		// put into blogPosts list
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addBlogPost(BlogPostDto blogPostDto) {
		
		logger.info("Adding new blog post: " + blogPostDto);
		
		BlogPostEntity blogPostEntity = new BlogPostEntity();
		blogPostEntity.setBlogTitle(blogPostDto.getTitle());
		blogPostEntity.setBlogContent(blogPostDto.getContent());
		blogPostEntity.setCreatedDate(Date.from(blogPostDto.getDateCreated().atZone(ZoneId.systemDefault()).toInstant()));
		
		if(persister.addBlogPost(blogPostEntity)) {
			logger.info("Successfully added new blog post");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteBlogPost(BlogPostDto blogPostDto) {
		logger.info("Deleting blog post: " + blogPostDto);
		BlogPostEntity blogPostEntity = persister.findBlogPost(blogPostDto.getPostId());
		if(blogPostEntity == null) {
			logger.error("Can't find blog post: " + blogPostDto.getPostId());
			return;
		}
		
		if(persister.deleteBlogPost(blogPostEntity)) {
			logger.info("Successfully deleted blog post: " + blogPostDto.getPostId());
			logger.debug(blogPostDto.toString());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void editBlogPost(BlogPostDto blogPostDto) {
		logger.info("Editing blog post: " + blogPostDto);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<BlogPost> getBlogList() {
		// TODO: just return data model in engine & have a scheduled task to hit database to update
		List<BlogPostEntity> blogPostEntities = persister.getBlogList();
		List<BlogPost> blogPosts = new ArrayList<>();
		
		blogPostEntities.stream().forEach(blogPostEntity -> {
			BlogPost blogPost = new BlogPost();
			
			blogPost.setPostId(blogPostEntity.getBlogPostId());
			blogPost.setTitle(blogPostEntity.getBlogTitle());
			blogPost.setContent(blogPostEntity.getBlogContent());
			
			if(blogPostEntity.getCreatedDate() != null) {
				blogPost.setDateCreated(LocalDateTime.ofInstant(blogPostEntity.getCreatedDate().toInstant(), 
						ZoneId.systemDefault()));
			}
			
			blogPosts.add(blogPost);
		});
		
		return blogPosts;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addBlogPostComment(BlogPostComment blogPostComment) {
		
		BlogPostCommentEntity blogPostCommentEntity = new BlogPostCommentEntity();
		blogPostCommentEntity.setComment(blogPostComment.getComment());
		blogPostCommentEntity.setCommentCreatedDate(Date.from(blogPostComment.getCommentCreated().atZone(ZoneId.systemDefault()).toInstant()));
		
		if(persister.addBlogPostComment(blogPostCommentEntity)) {
			logger.info("Successfully added new blog post comment");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlogPost getBlogPost(int blogPostId) {
		
		BlogPost blogPost = new BlogPost();
		
		BlogPostEntity blogPostEntity = persister.findBlogPost(blogPostId);
		if(blogPostEntity != null) {
			
			
			blogPost.setPostId(blogPostEntity.getBlogPostId());
			blogPost.setTitle(blogPostEntity.getBlogTitle());
			blogPost.setContent(blogPostEntity.getBlogContent());
			//blogPost.setDateCreated(blogPostEntity.getCreatedDate());
			
			List<BlogPostComment> blogPostComments = new ArrayList<>();
			blogPostEntity.getBlogPostComments().stream().forEach(blogPostCommentEntity -> {
				BlogPostComment blogPostComment = new BlogPostComment();
				blogPostComment.setComment(blogPostCommentEntity.getComment());
				blogPostComment.setCommentCreated(LocalDateTime.ofInstant(blogPostCommentEntity.getCommentCreatedDate().toInstant(), ZoneId.systemDefault()));
				
				blogPostComments.add(blogPostComment);
			});
			
			blogPost.setComments(blogPostComments);
			
		}
		return blogPost;
	}
	
	
}
