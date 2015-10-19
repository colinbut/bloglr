/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.persister.dao;

import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mycompany.bloglr.persister.dao.entity.BlogPostEntity;

/**
 * {@link BlogPostDaoImpl} implementation of {@link BlogPostDao} interface
 * 
 * @author colin
 *
 */
@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
public class BlogPostDaoImpl implements BlogPostDao {

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
		return blogPostEntity;
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