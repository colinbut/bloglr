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
import com.mycompany.bloglr.common.converter.Converter;
import com.mycompany.bloglr.common.converter.LocalDateTimeToDateConverter;
import com.mycompany.bloglr.persister.dao.entity.BlogPostEntity;

/**
 * 
 * @author colin
 *
 */
public class BlogPostToBlogPostEntityTransformer implements TypeTransformer<BlogPostEntity, BlogPost>{

	private Converter<Date, LocalDateTime> localDateTimeToDateConverter = new LocalDateTimeToDateConverter();
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlogPostEntity transform(BlogPost blogPost) {
		BlogPostEntity blogPostEntity = new BlogPostEntity();
		blogPostEntity.setBlogTitle(blogPost.getTitle());
		blogPostEntity.setBlogContent(blogPost.getContent());
		blogPostEntity.setCreatedDate(localDateTimeToDateConverter.convert(blogPost.getDateCreated()));
		return blogPostEntity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<BlogPostEntity> transform(Collection<BlogPost> blogPosts) {
		List<BlogPostEntity> blogPostEntities = new ArrayList<>();
		blogPosts.stream().forEach(blogPost -> blogPostEntities.add(transform(blogPost)));
		return blogPostEntities;
	}

	
	
}
