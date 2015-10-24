/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.bloglr.blogengine.BlogEngine;
import com.mycompany.bloglr.blogengine.domain.BlogPost;
import com.mycompany.bloglr.blogengine.domain.BlogPostComment;
import com.mycompany.bloglr.common.annotation.Controller;
import com.mycompany.bloglr.common.transformer.BlogPostCommentDtoToBlogPostCommentTransformer;
import com.mycompany.bloglr.common.transformer.BlogPostDtoToBlogPostTransformer;
import com.mycompany.bloglr.common.transformer.BlogPostToBlogPostDtoTransformer;
import com.mycompany.bloglr.common.transformer.TypeTransformer;
import com.mycompany.bloglr.controller.dto.BlogPostCommentDto;
import com.mycompany.bloglr.controller.dto.BlogPostDto;

/**
 * {@link BlogController} 
 * 
 * @author colin
 *
 */
@Controller
public class BlogController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BlogController.class);
	
	private TypeTransformer<BlogPost, BlogPostDto> blogPostDtoToBlogPostTransformer = new BlogPostDtoToBlogPostTransformer();
	private TypeTransformer<BlogPostDto, BlogPost> blogPostToBlogPostDtoTransformer = new BlogPostToBlogPostDtoTransformer();
	
	private TypeTransformer<BlogPostComment, BlogPostCommentDto> blogPostCommentDtoToBlogPostCommentTransformer = new BlogPostCommentDtoToBlogPostCommentTransformer();
	
	@Inject
	private BlogEngine blogEngine;
	
	/**
	 * Retrieves a blog post by the given id
	 * 
	 * @param blogPostId blog post id of the blog post
	 * @return 
	 */
	public BlogPostDto getBlogPost(int blogPostId) {
		BlogPost blogPost = blogEngine.getBlogPost(blogPostId);
		return blogPostToBlogPostDtoTransformer.transform(blogPost);
	}
	
	/**
	 * Adds a new blog post
	 * 
	 * @param blogPostDto
	 */
	public void addBlogPost(BlogPostDto blogPostDto) {
		LOGGER.info("Adding new blog post: " + blogPostDto);
		
		// convert from dto to model object
		BlogPost blogPost = blogPostDtoToBlogPostTransformer.transform(blogPostDto);
		blogEngine.addBlogPost(blogPost);
	}
	
	/**
	 * Deletes an existing blog post
	 * 
	 * @param blogPostDto
	 */
	public void deleteBlogPost(BlogPostDto blogPostDto) {
		LOGGER.info("Deleting blog post: " + blogPostDto);
		BlogPost blogPost = blogPostDtoToBlogPostTransformer.transform(blogPostDto);
		blogEngine.deleteBlogPost(blogPost);
	}
	
	/**
	 * Edit an existing blog post
	 * 
	 * @param blogPostDto
	 */
	public void editBlogPost(BlogPostDto blogPostDto) {
		LOGGER.info("Edit blog post: " + blogPostDto);
		BlogPost blogPost = blogPostDtoToBlogPostTransformer.transform(blogPostDto);
		blogEngine.editBlogPost(blogPost);
	}
	
	/**
	 * Retrieves a list of blog post
	 * 
	 * @return
	 */
	public List<BlogPostDto> getBlogPostList() {
		List<BlogPost> blogPosts = blogEngine.getBlogList();
		return blogPostToBlogPostDtoTransformer.transform(blogPosts);
	}
	
	/**
	 * Add a new comment to an existing blog post
	 * 
	 * @param blogPostCommentDto
	 */
	public void addBlogPostComment(BlogPostCommentDto blogPostCommentDto, int blogPostId) {
		LOGGER.info("Adding new comment: " + blogPostCommentDto.getComment());
		blogEngine.addBlogPostComment(blogPostCommentDtoToBlogPostCommentTransformer.transform(blogPostCommentDto), blogPostId);
	}
	
	
}
