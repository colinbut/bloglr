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

import com.mycompany.bloglr.blogengine.domain.BlogPost;
import com.mycompany.bloglr.blogengine.domain.BlogPostComment;
import com.mycompany.bloglr.common.converter.Converter;
import com.mycompany.bloglr.common.converter.DateToLocalDateTimeConverter;
import com.mycompany.bloglr.persister.dao.entity.BlogPostCommentEntity;
import com.mycompany.bloglr.persister.dao.entity.BlogPostEntity;

/**
 * A transformer that allows the transformation of a {@link BlogPostEntity} to a 
 * {@link BlogPost}
 * 
 * @author colin
 *
 */
public class BlogPostEntityToBlogPostTransformer implements TypeTransformer<BlogPost, BlogPostEntity> {

	private TypeTransformer<BlogPostComment, BlogPostCommentEntity> transformer = new BlogPostCommentEntityToBlogPostCommentTransformer();
	
	private Converter<LocalDateTime, Date> dateToLocalDateTimeConverter = new DateToLocalDateTimeConverter();
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlogPost transform(BlogPostEntity blogPostEntity) {
		BlogPost blogPost = new BlogPost();
		blogPost.setPostId(blogPostEntity.getBlogPostId());
		blogPost.setTitle(blogPostEntity.getBlogTitle());
		blogPost.setContent(blogPostEntity.getBlogContent());
		blogPost.setDateCreated(dateToLocalDateTimeConverter.convert(blogPostEntity.getCreatedDate()));
		blogPost.setComments(new ArrayList<>(transformer.transform(blogPostEntity.getBlogPostComments())));
		return blogPost;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<BlogPost> transform(Collection<BlogPostEntity> blogPostEntities) {
		List<BlogPost> blogPosts = new ArrayList<>();
		blogPostEntities.stream().forEach(blogPostEntity -> {
			blogPosts.add(transform(blogPostEntity));
		});
		return blogPosts;
	}

}
