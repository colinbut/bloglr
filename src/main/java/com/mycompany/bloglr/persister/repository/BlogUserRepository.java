/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.persister.repository;

import javax.ejb.Remote;

import com.mycompany.bloglr.persister.repository.entity.BlogUserEntity;

/**
 * {@link BlogUserRepository} interface
 * 
 * @author colin
 *
 */
@Remote
public interface BlogUserRepository {

	BlogUserEntity getUserById(int id);
}
