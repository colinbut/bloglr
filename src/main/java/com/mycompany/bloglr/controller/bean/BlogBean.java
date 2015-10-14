/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.controller.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.bloglr.domain.model.BlogPost;

/**
 * {@link BlogBean} 
 * 
 * @author colin
 *
 */
@ManagedBean
@ApplicationScoped
public class BlogBean implements Serializable {

	private static final long serialVersionUID = 2112003448015528406L;

	private static final Logger logger = LoggerFactory.getLogger(BlogBean.class);
	
	private List<BlogPost> blogList = new ArrayList<>();
	
	private boolean sortAscending = true;
	
	public List<BlogPost> getBlogList() {
		return blogList;
	}

	public void setBlogList(List<BlogPost> blogList) {
		this.blogList = blogList;
	}
		
	public BlogBean() {
		setupBlogPostStubs();
	}
	
	private void setupBlogPostStubs() {
		
		for(int i = 1; i <= 20; i++) {
			BlogPost blogPost = new BlogPost();
			blogPost.setPostId(i);
			blogPost.setTitle("Title");
			blogPost.setContent("Content");
			blogPost.setDateCreated(LocalDateTime.now());
			blogList.add(blogPost);
		}
		
	}
	
	
	public String addBlogPost(BlogPost blogPost) {
		return null;
	}
	
	public String deleteBlogPost(BlogPost blogPost) {
		logger.info("Deleting blog post: " + blogPost);
		blogList.remove(blogPost);
		return null;
	}
	
	public String editBlogPost(BlogPost blogPost) {
		logger.info("Edited blog post: " + blogPost);
		blogPost.setEditable(true);
		return null;
	}
	
	public String saveBlogPost() {
		blogList.stream().forEach(blogPost -> {blogPost.setEditable(false);});
		return null;
	}
	
	public String sortByPostId() {
		
		if(sortAscending) {
			Collections.sort(blogList, new Comparator<BlogPost>() {

				@Override
				public int compare(BlogPost o1, BlogPost o2) {
					String bp1 = Integer.toString(o1.getPostId());
					String bp2 = Integer.toString(o2.getPostId());
					return bp1.compareTo(bp2);
				}
			});
			sortAscending = false;
		} else {
			Collections.sort(blogList, new Comparator<BlogPost>() {

				@Override
				public int compare(BlogPost o1, BlogPost o2) {
					String bp1 = Integer.toString(o1.getPostId());
					String bp2 = Integer.toString(o2.getPostId());
					return bp2.compareTo(bp1);
				}
				
			});
			sortAscending = true;
		}
		
		return null;
	}
	
}
