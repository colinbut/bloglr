/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.common.transformer;

import java.time.LocalDateTime;
import java.util.*;

import com.mycompany.bloglr.blogengine.domain.BlogPost;
import com.mycompany.bloglr.blogengine.domain.BlogPostComment;
import com.mycompany.bloglr.common.converter.Converter;
import com.mycompany.bloglr.common.converter.LocalDateTimeToDateConverter;
import com.mycompany.bloglr.persister.dao.entity.BlogPostCommentEntity;
import com.mycompany.bloglr.persister.dao.entity.BlogPostEntity;

/**
 * 
 * @author colin
 *
 */
public class BlogPostToBlogPostEntityTransformer implements TypeTransformer<BlogPostEntity, BlogPost>{

	private Converter<Date, LocalDateTime> localDateTimeToDateConverter = new LocalDateTimeToDateConverter();
	
	private TypeTransformer<BlogPostCommentEntity, BlogPostComment> blogPostCommentEntityBlogPostCommentTypeTransformer = new BlogPostCommentToBlogPostCommentEntityTransformer();
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlogPostEntity transform(BlogPost blogPost) {
		BlogPostEntity blogPostEntity = new BlogPostEntity();
		blogPostEntity.setBlogPostId(blogPost.getPostId());
		blogPostEntity.setBlogTitle(blogPost.getTitle());
		blogPostEntity.setBlogContent(blogPost.getContent());

		blogPostEntity.setBlogPostComments(new HashSet<>(blogPostCommentEntityBlogPostCommentTypeTransformer.transform(blogPost.getComments())));
		blogPostEntity.getBlogPostComments().stream().forEach(blogPostCommentEntity -> {
			blogPostCommentEntity.setBlogPost(blogPostEntity);
		});

		blogPostEntity.setCreatedDate(localDateTimeToDateConverter.convert(blogPost.getDateCreated()));
		return blogPostEntity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<BlogPostEntity> transform(Collection<BlogPost> blogPosts) {
		Set<BlogPostEntity> blogPostEntities = new HashSet<>();
		blogPosts.stream().forEach(blogPost -> blogPostEntities.add(transform(blogPost)));
		return blogPostEntities;
	}

	
	
}
