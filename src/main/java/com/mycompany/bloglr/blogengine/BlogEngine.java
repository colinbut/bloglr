/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.blogengine;

import com.mycompany.bloglr.domain.dto.BlogPostDto;

/**
 * 
 * @author colin
 *
 */
public interface BlogEngine {

	void addBlogPost(BlogPostDto blogPostDto);
	
	void deleteBlogPost(BlogPostDto blogPostDto);
	
	void editBlogPost(BlogPostDto blogPostDto);
}
