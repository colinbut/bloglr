/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.blogengine;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.bloglr.blogengine.domain.BlogPost;
import com.mycompany.bloglr.common.annotation.DataAccess;
import com.mycompany.bloglr.controller.dto.BlogPostDto;
import com.mycompany.bloglr.persister.Persister;
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
		//blogPostEntity.setCreatedDate(blogPostDto.getDateCreated());
		
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
		BlogPostEntity blogPostEntity = persister.findBlogPost(1);
		persister.deleteBlogPost(blogPostEntity);
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
			blogPost.setTitle(blogPostEntity.getBlogTitle());
			blogPost.setContent(blogPostEntity.getBlogContent());
			
			blogPosts.add(blogPost);
		});
		
		return blogPosts;
	}
	
	
}
