/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.persister.repository;

import javax.ejb.Remote;

import com.mycompany.bloglr.persister.repository.entities.BlogPostEntity;

/**
 * {@link BlogPostRepository} interface
 * 
 * @author colin
 *
 */
@Remote
public interface BlogPostRepository {

	BlogPostEntity findById();
}
