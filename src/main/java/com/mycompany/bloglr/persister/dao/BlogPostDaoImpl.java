/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.persister.dao;

import java.util.List;

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
		return entityManager.find(BlogPostEntity.class, id);
	}

	/**
	 * {@inheritDoc}
     */
	@Override
	public BlogPostEntity add(BlogPostEntity blogPostEntity) {
		entityManager.persist(blogPostEntity);
		return blogPostEntity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlogPostEntity save(BlogPostEntity blogPostEntity) {
		entityManager.merge(blogPostEntity);
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<BlogPostEntity> getAll() {
		return entityManager.createQuery("SELECT B FROM BlogPostEntity B", BlogPostEntity.class).getResultList();
	}
	
}
