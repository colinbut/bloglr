/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.persister;

import java.util.List;

import javax.ejb.EJB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.bloglr.common.annotation.DataAccess;
import com.mycompany.bloglr.persister.dao.BlogPostCommentDao;
import com.mycompany.bloglr.persister.dao.BlogPostDao;
import com.mycompany.bloglr.persister.dao.BlogUserDao;
import com.mycompany.bloglr.persister.dao.entity.BlogPostCommentEntity;
import com.mycompany.bloglr.persister.dao.entity.BlogPostEntity;

/**
 * {@link PersisterImpl} - implementation of {@link Persister} interface
 * 
 * @author colin
 *
 */
@DataAccess
public class PersisterImpl implements Persister {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersisterImpl.class);
	
	@EJB
	private BlogUserDao blogUserDao;
	
	@EJB
	private BlogPostDao blogPostDao;
	
	@EJB
	private BlogPostCommentDao blogPostCommentDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlogPostEntity findBlogPost(int id) {
		LOGGER.info("Finding blog post: " + id);
		return blogPostDao.findById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addBlogPost(BlogPostEntity blogPostEntity) {
		
		LOGGER.info("Adding new blog post to database");
		
		BlogPostEntity savedBlogPostEntity = blogPostDao.add(blogPostEntity);
		if(savedBlogPostEntity != null) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
     */
	@Override
	public boolean saveBlogPost(BlogPostEntity blogPostEntity) {
		LOGGER.info("Saving existing blog post to database");

		BlogPostEntity savedBlogPostEntity = blogPostDao.save(blogPostEntity);
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
		blogPostDao.delete(blogPostEntity);
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<BlogPostEntity> getBlogList() {
		return blogPostDao.getAll();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addBlogPostComment(BlogPostCommentEntity blogPostCommentEntity) {
		if(blogPostCommentDao.addBlogPostComment(blogPostCommentEntity) != null) {
			return true;
		}
		return false;
	}
}
