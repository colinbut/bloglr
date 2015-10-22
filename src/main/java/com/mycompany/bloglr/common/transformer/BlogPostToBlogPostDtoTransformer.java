/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.common.transformer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.mycompany.bloglr.blogengine.domain.BlogPost;
import com.mycompany.bloglr.blogengine.domain.BlogPostComment;
import com.mycompany.bloglr.controller.dto.BlogPostCommentDto;
import com.mycompany.bloglr.controller.dto.BlogPostDto;

/**
 * 
 * @author colin
 *
 */
public class BlogPostToBlogPostDtoTransformer implements TypeTransformer<BlogPostDto, BlogPost> {

	private TypeTransformer<BlogPostCommentDto, BlogPostComment> blogPostCommentToBlogPostCommentDtoTransformer = new BlogPostCommentToBlogPostCommentDtoTransformer();
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlogPostDto transform(BlogPost blogPost) {
		BlogPostDto blogPostDto = new BlogPostDto();
		blogPostDto.setPostId(blogPost.getPostId());
		blogPostDto.setTitle(blogPost.getTitle());
		blogPostDto.setContent(blogPost.getContent());
		blogPostDto.setDateCreated(blogPost.getDateCreated());
		blogPostDto.setBlogPostComments(blogPostCommentToBlogPostCommentDtoTransformer.transform(blogPost.getComments()));
		return blogPostDto;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<BlogPostDto> transform(Collection<BlogPost> blogPosts) {
		List<BlogPostDto> blogPostDtos = new ArrayList<>();
		blogPosts.stream().forEach(blogPost -> {
			blogPostDtos.add(transform(blogPost));
		});
		return blogPostDtos;
	}

}
