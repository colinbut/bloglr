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
public class BlogPostCommentDtoToBlogPostCommentTransformer implements TypeTransformer<BlogPostComment, BlogPostCommentDto>{

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlogPostComment transform(BlogPostCommentDto blogPostCommentDto) {
		BlogPostComment blogPostComment = new BlogPostComment();
		blogPostComment.setComment(blogPostCommentDto.getComment());
		blogPostComment.setCommentCreated(blogPostCommentDto.getCommentCreated());
		return blogPostComment;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<BlogPostComment> transform(Collection<BlogPostCommentDto> blogPostCommentDtos) {
		List<BlogPostComment> blogPostComments = new ArrayList<>();
		blogPostCommentDtos.stream().forEach(blogPostCommentDto -> {
			blogPostComments.add(transform(blogPostCommentDto));
		});
		return blogPostComments;
	}

}
