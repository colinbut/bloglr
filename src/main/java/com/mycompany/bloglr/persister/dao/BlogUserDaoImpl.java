/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.persister.dao;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mycompany.bloglr.persister.dao.entity.BlogUserEntity;

/**
 * {@link BlogUserDaoImpl} implementation of {@link BlogUserDao} interface
 * 
 * @author colin
 *
 */
@Stateful
public class BlogUserDaoImpl implements BlogUserDao {

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
