/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.persister;

import javax.ejb.Remote;

import com.mycompany.bloglr.persister.repository.entity.BlogPostEntity;

/**
 * @author colin
 *
 */
@Remote
public interface Persister {

	BlogPostEntity findBlogPost(int id);
	
	boolean addBlogPost(BlogPostEntity blogPostEntity);

	boolean editBlogPost(BlogPostEntity blogPostEntity);
	
	boolean deleteBlogPost(BlogPostEntity blogPostEntity);
	
	
}
