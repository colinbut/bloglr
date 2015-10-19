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

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.bloglr.controller.BlogController;
import com.mycompany.bloglr.controller.dto.BlogPostDto;

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
	
	private List<BlogPostDto> blogList = new ArrayList<>();
	
	private boolean sortAscending = true;
	
	@Inject
	private BlogController controller;
	
	
		
	/**
	 * Constructor
	 */
	public BlogBean() {
		//setupBlogPostStubs();
	}
	
	
	@PostConstruct
	private void init() {
		blogList = controller.getBlogPostList();
	}
	
//	private void setupBlogPostStubs() {
//		
//		for(int i = 1; i <= 20; i++) {
//			BlogPostDto blogPost = new BlogPostDto();
//			blogPost.setPostId(i);
//			blogPost.setTitle("Title");
//			blogPost.setContent("Content");
//			blogPost.setDateCreated(LocalDateTime.now());
//			blogList.add(blogPost);
//		}
//		
//	}
	
	
	public String deleteBlogPost(BlogPostDto blogPostDto) {
		logger.info("Deleting blog post: " + blogPostDto);
		controller.deleteBlogPost(blogPostDto);
		blogList.remove(blogPostDto);
		return null;
	}
	
	public String editBlogPost(BlogPostDto blogPostdto) {
		logger.info("Edited blog post: " + blogPostdto);
		blogPostdto.setEditable(true);
		return null;
	}
	
	public String saveBlogPost() {
		blogList.stream().forEach(blogPost -> {blogPost.setEditable(false);});
		return null;
	}
	
	public String sortByPostId() {
		
		if(sortAscending) {
			Collections.sort(blogList, new Comparator<BlogPostDto>() {

				@Override
				public int compare(BlogPostDto o1, BlogPostDto o2) {
					String bp1 = Integer.toString(o1.getPostId());
					String bp2 = Integer.toString(o2.getPostId());
					return bp1.compareTo(bp2);
				}
			});
			sortAscending = false;
		} else {
			Collections.sort(blogList, new Comparator<BlogPostDto>() {

				@Override
				public int compare(BlogPostDto o1, BlogPostDto o2) {
					String bp1 = Integer.toString(o1.getPostId());
					String bp2 = Integer.toString(o2.getPostId());
					return bp2.compareTo(bp1);
				}
				
			});
			sortAscending = true;
		}
		
		return null;
	}
	
	public List<BlogPostDto> getBlogList() {
		blogList = controller.getBlogPostList();
		return blogList;
	}

	public void setBlogList(List<BlogPostDto> blogList) {
		this.blogList = blogList;
	}
	
}
