/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.persister.repository;

import javax.ejb.Remote;

import com.mycompany.bloglr.persister.repository.entity.BlogPostEntity;

/**
 * {@link BlogPostRepository} interface
 * 
 * @author colin
 *
 */
@Remote
public interface BlogPostRepository {

	BlogPostEntity findById(int id);
	
	BlogPostEntity save(BlogPostEntity blogPostEntity);
	
	BlogPostEntity delete(BlogPostEntity blogPostEntity);
}
