/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.blogengine;

import java.util.List;

import com.mycompany.bloglr.blogengine.domain.BlogPostComment;
import com.mycompany.bloglr.blogengine.domain.BlogPost;

/**
 * The engine of the blog. Contains the main business logic for 
 * the whole blog application
 * 
 * Can be seen as acting as a facade to more internal layers further down the 
 * system
 * 
 * @author colin
 *
 */
public interface BlogEngine {

	BlogPost getBlogPost(int blogPostId);
	
	void addBlogPost(BlogPost blogPost);
	
	void deleteBlogPost(BlogPost blogPostDto);
	
	void editBlogPost(BlogPost blogPostDto);
	
	List<BlogPost> getBlogList();
	
	void addBlogPostComment(BlogPostComment blogPostComment, int blogPostId);
	
	
}
