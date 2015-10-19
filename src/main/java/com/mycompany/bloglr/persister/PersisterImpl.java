/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.persister;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.bloglr.common.annotation.DataAccess;
import com.mycompany.bloglr.persister.dao.BlogPostDao;
import com.mycompany.bloglr.persister.dao.BlogUserDao;
import com.mycompany.bloglr.persister.dao.entity.BlogPostEntity;

/**
 * {@link PersisterImpl} - implementation of {@link Persister} interface
 * 
 * @author colin
 *
 */
@DataAccess
public class PersisterImpl implements Persister {

	private static final Logger logger = LoggerFactory.getLogger(PersisterImpl.class);
	
	@EJB
	private BlogUserDao blogUserRepository;
	
	@EJB
	private BlogPostDao blogPostRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlogPostEntity findBlogPost(int id) {
		logger.info("Finding blog post: " + id);
		return blogPostRepository.findById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addBlogPost(BlogPostEntity blogPostEntity) {
		
		logger.info("Adding new blog post to database");
		
		BlogPostEntity savedBlogPostEntity = blogPostRepository.save(blogPostEntity);
		if(savedBlogPostEntity != null) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean editBlogPost(BlogPostEntity blogPostEntity) {
		return addBlogPost(blogPostEntity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteBlogPost(BlogPostEntity blogPostEntity) {
		blogPostRepository.delete(blogPostEntity);
		return false;
	}
	
	
}
