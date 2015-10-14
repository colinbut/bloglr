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

import com.mycompany.bloglr.common.annotation.DataAccess;
import com.mycompany.bloglr.persister.repository.BlogPostRepository;
import com.mycompany.bloglr.persister.repository.BlogUserRepository;
import com.mycompany.bloglr.persister.repository.entity.BlogPostEntity;

/**
 * {@link PersisterImpl} - implementation of {@link Persister} interface
 * 
 * @author colin
 *
 */
@Model
public class PersisterImpl implements Persister {

	@EJB
	private BlogUserRepository blogUserRepository;
	
	@EJB
	private BlogPostRepository blogPostRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlogPostEntity findBlogPost(int id) {
		return blogPostRepository.findById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addBlogPost(BlogPostEntity blogPostEntity) {
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
