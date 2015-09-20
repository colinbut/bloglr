/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.bloglr.persister.repository.BlogUserRepository;
import com.mycompany.bloglr.persister.repository.entities.BlogUserEntity;

/**
 * @author colin
 *
 */
@ManagedBean
@ApplicationScoped
public class BlogBean implements Serializable {

	private static final long serialVersionUID = 2112003448015528406L;

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@EJB
	private BlogUserRepository blogUserRepository;
		
	public BlogBean() {
		
	}
	
	public String getUsers() {
		BlogUserEntity blogUser = blogUserRepository.getUserById(1);
		logger.info("Getting User: " + blogUser.toString());
		return null;
	}
	
	public BlogUserRepository getBlogUserRepository() {
		return blogUserRepository;
	}

	public void setBlogUserRepository(BlogUserRepository blogUserRepository) {
		this.blogUserRepository = blogUserRepository;
	}
}
