/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.persister;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import com.mycompany.bloglr.persister.repository.BlogPostRepository;
import com.mycompany.bloglr.persister.repository.BlogUserRepository;

/**
 * @author colin
 *
 */
@Stateful
public class Persister {

	@EJB
	private BlogUserRepository blogUserRepository;
	
	@EJB
	private BlogPostRepository blogPostRepository;
}
