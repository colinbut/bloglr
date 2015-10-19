/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.persister;

import java.util.List;

import javax.ejb.Remote;

import com.mycompany.bloglr.persister.dao.entity.BlogPostEntity;

/**
 * @author colin
 *
 */
//@Remote
public interface Persister {

	BlogPostEntity findBlogPost(int id);
	
	boolean addBlogPost(BlogPostEntity blogPostEntity);

	boolean editBlogPost(BlogPostEntity blogPostEntity);
	
	boolean deleteBlogPost(BlogPostEntity blogPostEntity);
	
	List<BlogPostEntity> getBlogList();
	
}
