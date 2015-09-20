/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.persister.repository;

import javax.ejb.Stateful;
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
public class BlogPostRepositoryImpl implements BlogPostRepository {

	@PersistenceContext(unitName = "com.mycompany.bloglr.entitymanager")
	private EntityManager entityManager;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlogPostEntity findById() {
		throw new UnsupportedOperationException("Not Yet Implemented!");
	}
	
}
