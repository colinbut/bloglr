/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.persister.repository;

import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mycompany.bloglr.persister.repository.entities.BlogPostEntity;

/**
 * {@link BlogPostRepositoryImpl} implementation of {@link BlogPostRepository} interface
 * 
 * @author colin
 *
 */
@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
public class BlogPostRepositoryImpl implements BlogPostRepository {

	@PersistenceContext(unitName = "com.mycompany.bloglr.entitymanager")
	private EntityManager entityManager;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlogPostEntity findById(int id) {
		BlogPostEntity blogPostEntity = entityManager.find(BlogPostEntity.class, id);
		return blogPostEntity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlogPostEntity save(BlogPostEntity blogPostEntity) {
		entityManager.persist(blogPostEntity);
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlogPostEntity delete(BlogPostEntity blogPostEntity) {
		entityManager.remove(blogPostEntity);
		return null;
	}
	
}
