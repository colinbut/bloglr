/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.bloglr.blogengine.BlogEngine;
import com.mycompany.bloglr.blogengine.domain.BlogPost;
import com.mycompany.bloglr.blogengine.domain.BlogPostComment;
import com.mycompany.bloglr.common.annotation.Controller;
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

	private static final Logger logger = LoggerFactory.getLogger(BlogController.class);
	
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
		BlogPostDto blogPostDto = new BlogPostDto();
		
		//blogPostDto.setPostId(blogPost.getPostId());
		blogPostDto.setTitle(blogPost.getTitle());
		blogPostDto.setContent(blogPost.getContent());
		
		List<BlogPostCommentDto> blogPostCommentDtos = new ArrayList<>();
		blogPost.getComments().stream().forEach(blogPostComment -> {
			BlogPostCommentDto blogPostCommentDto = new BlogPostCommentDto();
			blogPostCommentDto.setComment(blogPostComment.getComment());
			blogPostCommentDto.setCommentCreated(blogPostComment.getCommentCreated());
			blogPostCommentDtos.add(blogPostCommentDto);
		});
		
		blogPostDto.setBlogPostComments(blogPostCommentDtos);
		
		return blogPostDto;
	}
	
	/**
	 * Adds a new blog post
	 * 
	 * @param blogPostDto
	 */
	public void addBlogPost(BlogPostDto blogPostDto) {
		logger.info("Adding new blog post: " + blogPostDto);
		blogEngine.addBlogPost(blogPostDto);
	}
	
	/**
	 * Deletes an existing blog post
	 * 
	 * @param blogPostDto
	 */
	public void deleteBlogPost(BlogPostDto blogPostDto) {
		logger.info("Deleting blog post: " + blogPostDto);
		blogEngine.deleteBlogPost(blogPostDto);
	}
	
	/**
	 * Edit an existing blog post
	 * 
	 * @param blogPostDto
	 */
	public void editBlogPost(BlogPostDto blogPostDto) {
		logger.info("Edit blog post: " + blogPostDto);
		blogEngine.editBlogPost(blogPostDto);
	}
	
	/**
	 * Retrieves a list of blog post
	 * 
	 * @return
	 */
	public List<BlogPostDto> getBlogPostList() {
		List<BlogPost> blogPosts = blogEngine.getBlogList();
		List<BlogPostDto> blogPostDtos = new ArrayList<>();
		
		blogPosts.stream().forEach(blogPost -> {
			BlogPostDto blogPostDto = new BlogPostDto();
			blogPostDto.setTitle(blogPost.getTitle());
			blogPostDto.setContent(blogPost.getContent());
			blogPostDto.setPostId(blogPost.getPostId());
			blogPostDto.setDateCreated(blogPost.getDateCreated());
			
			blogPostDtos.add(blogPostDto);
		});
		
		return blogPostDtos;
	}
	
	/**
	 * Add a new comment to an existing blog post
	 * 
	 * @param blogPostCommentDto
	 */
	public void addBlogPostComment(BlogPostCommentDto blogPostCommentDto) {
		logger.info("Adding new comment: " + blogPostCommentDto.getComment());
		
		BlogPostComment blogPostComment = new BlogPostComment();
		blogPostComment.setComment(blogPostCommentDto.getComment());
		blogPostComment.setCommentCreated(blogPostCommentDto.getCommentCreated());
		
		blogEngine.addBlogPostComment(blogPostComment);
		
	}
	
	
}
