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
import com.mycompany.bloglr.controller.dto.BlogPostDto;

/**
 * 
 * @author colin
 *
 */
public class BlogPostDtoToBlogPostTransformer implements TypeTransformer<BlogPost, BlogPostDto> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlogPost transform(BlogPostDto blogPostDto) {
		BlogPost blogPost = new BlogPost();
		blogPost.setTitle(blogPostDto.getTitle());
		blogPost.setContent(blogPostDto.getContent());
		blogPost.setDateCreated(blogPostDto.getDateCreated());
		return blogPost;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<BlogPost> transform(Collection<BlogPostDto> blogPostDtos) {
		List<BlogPost> blogPosts = new ArrayList<>();
		blogPostDtos.stream().forEach(blogPostDto -> {
			blogPosts.add(transform(blogPostDto));
		});
		return blogPosts;
	}

}
