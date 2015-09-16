/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.domain.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author colin
 *
 */
public class BlogPost {

	private String title;
	private Author author;
	private LocalDateTime dateCreated;
	private LocalDateTime dateUpdated;
	private String content;
	private List<BlogComment> comments;
}
