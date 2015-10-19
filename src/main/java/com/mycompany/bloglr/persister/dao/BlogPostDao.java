/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.persister.dao;

import javax.ejb.Remote;

import com.mycompany.bloglr.persister.dao.entity.BlogPostEntity;

/**
 * {@link BlogPostDao} interface
 * 
 * @author colin
 *
 */
@Remote
public interface BlogPostDao {

	BlogPostEntity findById(int id);
	
	BlogPostEntity save(BlogPostEntity blogPostEntity);
	
	BlogPostEntity delete(BlogPostEntity blogPostEntity);
}
