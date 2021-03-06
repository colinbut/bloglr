/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.common.transformer;


import java.time.LocalDateTime;
import java.util.*;

import com.mycompany.bloglr.blogengine.domain.BlogPostComment;
import com.mycompany.bloglr.common.converter.Converter;
import com.mycompany.bloglr.common.converter.LocalDateTimeToDateConverter;
import com.mycompany.bloglr.persister.dao.entity.BlogPostCommentEntity;

/**
 * 
 * @author colin
 *
 */
public class BlogPostCommentToBlogPostCommentEntityTransformer implements 
				TypeTransformer<BlogPostCommentEntity, BlogPostComment>{

	private Converter<Date, LocalDateTime> localDateTimeToDateConverter = new LocalDateTimeToDateConverter();
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlogPostCommentEntity transform(BlogPostComment blogPostComment) {
		BlogPostCommentEntity blogPostCommentEntity = new BlogPostCommentEntity();
		blogPostCommentEntity.setComment(blogPostComment.getComment());
		blogPostCommentEntity.setCommentCreatedDate(localDateTimeToDateConverter.convert(blogPostComment.getCommentCreated()));
		return blogPostCommentEntity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<BlogPostCommentEntity> transform(Collection<BlogPostComment> blogPostComments) {
		Set<BlogPostCommentEntity> blogPostCommentEntities = new HashSet<>();
		blogPostComments.stream().forEach(blogPostComment -> blogPostCommentEntities.add(transform(blogPostComment)));
		return blogPostCommentEntities;
	}

	
	
}
