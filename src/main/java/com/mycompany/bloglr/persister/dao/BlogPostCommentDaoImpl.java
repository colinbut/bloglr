/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.persister.dao;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mycompany.bloglr.persister.dao.entity.BlogPostCommentEntity;

/**
 * 
 * @author colin
 *
 */
@Stateful
public class BlogPostCommentDaoImpl implements BlogPostCommentDao {

	@PersistenceContext(unitName = "com.mycompany.bloglr.entitymanager")
	private EntityManager entityManager;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlogPostCommentEntity addBlogPostComment(BlogPostCommentEntity blogPostCommentEntity) {
		entityManager.persist(blogPostCommentEntity);
		return blogPostCommentEntity;
	}

}
