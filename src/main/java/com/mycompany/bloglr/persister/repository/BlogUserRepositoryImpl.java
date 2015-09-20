/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.persister.repository;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mycompany.bloglr.persister.repository.entities.BlogUserEntity;

/**
 * {@link BlogUserRepositoryImpl} implementation of {@link BlogUserRepository} interface
 * 
 * @author colin
 *
 */
@Stateful
public class BlogUserRepositoryImpl implements BlogUserRepository {

	@PersistenceContext(unitName = "com.mycompany.bloglr.entitymanager")
	private EntityManager entityManager;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlogUserEntity getUserById(int id) {
		BlogUserEntity blogUserEntity = entityManager.find(BlogUserEntity.class, 1);
		return blogUserEntity;
	}
	
}
