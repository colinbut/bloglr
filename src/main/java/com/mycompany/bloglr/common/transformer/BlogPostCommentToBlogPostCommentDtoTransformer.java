/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.common.transformer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.mycompany.bloglr.blogengine.domain.BlogPostComment;
import com.mycompany.bloglr.controller.dto.BlogPostCommentDto;

/**
 * 
 * @author colin
 *
 */
public class BlogPostCommentToBlogPostCommentDtoTransformer implements TypeTransformer<BlogPostCommentDto, BlogPostComment>{

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlogPostCommentDto transform(BlogPostComment blogPostComment) {
		BlogPostCommentDto blogPostCommentDto = new BlogPostCommentDto();
		blogPostCommentDto.setComment(blogPostComment.getComment());
		blogPostCommentDto.setCommentCreated(blogPostComment.getCommentCreated());
		return blogPostCommentDto;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<BlogPostCommentDto> transform(Collection<BlogPostComment> blogPostComments) {
		List<BlogPostCommentDto> blogPostCommentDtos = new ArrayList<>();
		blogPostComments.stream().forEach(blogPostComment -> {
			blogPostCommentDtos.add(transform(blogPostComment));
		});
		return blogPostCommentDtos;
	}

}
