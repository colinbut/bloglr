/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.blogengine;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.bloglr.blogengine.domain.BlogPostComment;
import com.mycompany.bloglr.blogengine.domain.BlogPost;
import com.mycompany.bloglr.common.transformer.BlogPostCommentToBlogPostCommentEntityTransformer;
import com.mycompany.bloglr.common.transformer.BlogPostEntityToBlogPostTransformer;
import com.mycompany.bloglr.common.transformer.BlogPostToBlogPostEntityTransformer;
import com.mycompany.bloglr.common.transformer.TypeTransformer;
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
	
	
	private TypeTransformer<BlogPost, BlogPostEntity> blogPostEntityToBlogPostTransformer = new BlogPostEntityToBlogPostTransformer();
	private TypeTransformer<BlogPostEntity, BlogPost> blogPostToBlogPostEntityTransformer = new BlogPostToBlogPostEntityTransformer();
	
	//private TypeTransformer<BlogPostCommentEntity, BlogPostComment> blogPostCommentToBlogPostCommentEntityTransformer = new BlogPostCommentToBlogPostCommentEntityTransformer();
	
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
	public void addBlogPost(BlogPost blogPost) {
		
		logger.info("Adding new blog post: " + blogPost);
				
		// should add to list
		blogPosts.add(blogPost);
		
		// convert from model object to entity
		BlogPostEntity blogPostEntity = blogPostToBlogPostEntityTransformer.transform(blogPost);
		
		if(persister.addBlogPost(blogPostEntity)) {
			logger.info("Successfully added new blog post");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteBlogPost(BlogPost blogPost) {
		logger.info("Deleting blog post: " + blogPost);
		BlogPostEntity blogPostEntity = persister.findBlogPost(blogPost.getPostId());
		if(blogPostEntity == null) {
			logger.error("Can't find blog post: " + blogPost.getPostId());
			return;
		}
		
		if(persister.deleteBlogPost(blogPostEntity)) {
			logger.info("Successfully deleted blog post: " + blogPost.getPostId());
			logger.debug(blogPost.toString());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void editBlogPost(BlogPost blogPost) {
		logger.info("Editing blog post: " + blogPost);
		throw new UnsupportedOperationException("Not Yet Implemented!");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<BlogPost> getBlogList() {
		// TODO: just return data model in engine & have a scheduled task to hit database to update
		List<BlogPostEntity> blogPostEntities = persister.getBlogList();
		List<BlogPost> blogPosts = blogPostEntityToBlogPostTransformer.transform(blogPostEntities);
		return blogPosts;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addBlogPostComment(BlogPostComment blogPostComment, int blogPostId) {
		
		// TODO: find the blog (should get from existing model
		BlogPost blogPost = getBlogPost(blogPostId);
		
		// add to model
		blogPost.getComments().add(blogPostComment);
		
		// actually save blog post
		addBlogPost(blogPost);
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlogPost getBlogPost(int blogPostId) {
		BlogPostEntity blogPostEntity = persister.findBlogPost(blogPostId);
		BlogPost blogPost = blogPostEntityToBlogPostTransformer.transform(blogPostEntity);
		return blogPost;
	}
	
	
}
