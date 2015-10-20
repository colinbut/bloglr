/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.blogengine;

import java.util.List;

import com.mycompany.bloglr.blogengine.domain.BlogPostComment;
import com.mycompany.bloglr.blogengine.domain.BlogPost;
import com.mycompany.bloglr.controller.dto.BlogPostDto;

/**
 * 
 * @author colin
 *
 */
public interface BlogEngine {

	BlogPost getBlogPost(int blogPostId);
	
	void addBlogPost(BlogPostDto blogPostDto);
	
	void deleteBlogPost(BlogPostDto blogPostDto);
	
	void editBlogPost(BlogPostDto blogPostDto);
	
	List<BlogPost> getBlogList();
	
	void addBlogPostComment(BlogPostComment blogPostComment);
	
	
}
