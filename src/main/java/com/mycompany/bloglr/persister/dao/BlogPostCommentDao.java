/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.persister.dao;

import javax.ejb.Remote;

import com.mycompany.bloglr.persister.dao.entity.BlogPostCommentEntity;

/**
 * 
 * @author colin
 *
 */
@Remote
public interface BlogPostCommentDao {

	BlogPostCommentEntity addBlogPostComment(BlogPostCommentEntity blogPostComment);
}
