/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.common.transformer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.mycompany.bloglr.blogengine.domain.BlogPostComment;
import com.mycompany.bloglr.common.converter.Converter;
import com.mycompany.bloglr.common.converter.DateToLocalDateTimeConverter;
import com.mycompany.bloglr.persister.dao.entity.BlogPostCommentEntity;

/**
 * A transformer that allows the transformation of a {@link BlogPostCommentEntity} to a 
 * {@link BlogPostComment}
 * 
 * @author colin
 *
 */
public class BlogPostCommentEntityToBlogPostCommentTransformer implements 
							TypeTransformer<BlogPostComment, BlogPostCommentEntity> {

	private Converter<LocalDateTime, Date> dateToLocalDateTimeConverter = new DateToLocalDateTimeConverter();
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlogPostComment transform(BlogPostCommentEntity blogPostCommentEntity) {
		BlogPostComment blogPostComment = new BlogPostComment();
		blogPostComment.setComment(blogPostCommentEntity.getComment());
		blogPostComment.setCommentCreated(dateToLocalDateTimeConverter.convert(blogPostCommentEntity.getCommentCreatedDate()));
		return blogPostComment;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<BlogPostComment> transform(Collection<BlogPostCommentEntity> blogPostCommentEntities) {
		List<BlogPostComment> blogPostComments = new ArrayList<>();
		blogPostCommentEntities.stream().forEach(blogPostCommentEntity -> {
			blogPostComments.add(transform(blogPostCommentEntity));
		});
		return blogPostComments;
	}

}
