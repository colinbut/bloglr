/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.blogengine;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.bloglr.blogengine.domain.BlogPostComment;
import com.mycompany.bloglr.blogengine.domain.BlogPost;
import com.mycompany.bloglr.common.transformer.BlogPostEntityToBlogPostTransformer;
import com.mycompany.bloglr.common.transformer.BlogPostToBlogPostEntityTransformer;
import com.mycompany.bloglr.common.transformer.TypeTransformer;
import com.mycompany.bloglr.persister.Persister;
import com.mycompany.bloglr.persister.dao.entity.BlogPostEntity;

/**
 * Implementation of {@link BlogEngine} interface
 * 
 * @author colin
 *
 */
@Model
@Transactional(Transactional.TxType.SUPPORTS)
public class BlogEngineImpl implements BlogEngine {

	private static final Logger LOGGER = LoggerFactory.getLogger(BlogEngineImpl.class);
	
	@Inject
	private Persister persister;
	
	
	private TypeTransformer<BlogPost, BlogPostEntity> blogPostEntityToBlogPostTransformer = new BlogPostEntityToBlogPostTransformer();
	private TypeTransformer<BlogPostEntity, BlogPost> blogPostToBlogPostEntityTransformer = new BlogPostToBlogPostEntityTransformer();
	
	//private TypeTransformer<BlogPostCommentEntity, BlogPostComment> blogPostCommentToBlogPostCommentEntityTransformer = new BlogPostCommentToBlogPostCommentEntityTransformer();
	
	private List<BlogPost> blogPosts = new ArrayList<>();
	
	/**
	 * Constructor
	 */
	public BlogEngineImpl() {
		
	}
	
	private void loadBlogPosts() {
		// load from db
		
		// put into blogPosts list
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addBlogPost(BlogPost blogPost) {
		
		LOGGER.info("Adding new blog post: " + blogPost);
				
		// should add to list
		blogPosts.add(blogPost);


		// convert from model object to entity
		BlogPostEntity blogPostEntity = blogPostToBlogPostEntityTransformer.transform(blogPost);
		LOGGER.info(blogPostEntity.toString());

		if(persister.addBlogPost(blogPostEntity)) {
			LOGGER.info(String.format("Successfully added new blog post: %s", blogPost));

		}


	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(Transactional.TxType.REQUIRES_NEW)
	public void deleteBlogPost(BlogPost blogPost) {
		LOGGER.info("Deleting blog post: " + blogPost);
		BlogPostEntity blogPostEntity = persister.findBlogPost(blogPost.getPostId());
		if(blogPostEntity == null) {
			LOGGER.error("Can't find blog post: " + blogPost.getPostId());
			return;
		}
		
		if(persister.deleteBlogPost(blogPostEntity)) {
			LOGGER.info("Successfully deleted blog post: " + blogPost.getPostId());
			LOGGER.debug(blogPost.toString());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void editBlogPost(BlogPost blogPost) {
		LOGGER.info("Editing blog post: " + blogPost);
		throw new UnsupportedOperationException("Not Yet Implemented!");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<BlogPost> getBlogList() {
		// TODO: just return data model in engine & have a scheduled task to hit database to update
		List<BlogPostEntity> blogPostEntities = persister.getBlogList();
		List<BlogPost> blogPosts = new ArrayList<>(blogPostEntityToBlogPostTransformer.transform(blogPostEntities));
		return blogPosts;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addBlogPostComment(BlogPostComment blogPostComment, int blogPostId) {
		
		// TODO: find the blog (should get from existing model)
        BlogPost blogPost1 = null;
        for(BlogPost bp1 : blogPosts) {
            if(bp1.getPostId() == blogPostId) {
                blogPost1 = bp1;
                break;
            }
        }

        // Gets from DB
		BlogPost blogPost = getBlogPost(blogPostId);
		
		// add to model
		blogPost.getComments().add(blogPostComment);
		
		// actually save blog post
		// convert from model object to entity
		BlogPostEntity blogPostEntity = blogPostToBlogPostEntityTransformer.transform(blogPost);
		LOGGER.info(blogPostEntity.toString());
		persister.saveBlogPost(blogPostEntity);
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlogPost getBlogPost(int blogPostId) {
		BlogPostEntity blogPostEntity = persister.findBlogPost(blogPostId);
		BlogPost blogPost = blogPostEntityToBlogPostTransformer.transform(blogPostEntity);
		return blogPost;
	}


	
}
