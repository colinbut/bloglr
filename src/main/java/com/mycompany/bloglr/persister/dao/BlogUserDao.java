/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.persister.dao;

import javax.ejb.Remote;

import com.mycompany.bloglr.persister.dao.entity.BlogUserEntity;

/**
 * {@link BlogUserDao} interface
 * 
 * @author colin
 *
 */
@Remote
public interface BlogUserDao {

	BlogUserEntity getUserById(int id);
}
