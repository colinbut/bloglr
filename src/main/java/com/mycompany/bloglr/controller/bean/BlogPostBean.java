/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.controller.bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.mycompany.bloglr.blogengine.domain.BlogPostComment;
import com.mycompany.bloglr.controller.BlogController;
import com.mycompany.bloglr.controller.dto.BlogPostCommentDto;
import com.mycompany.bloglr.controller.dto.BlogPostDto;

/**
 * {@link BlogPostBean}
 *
 * @author colin
 */
@ManagedBean
@RequestScoped
public class BlogPostBean {

    private int blogPostId;
    private String blogPostTitle;
    private String blogPostContent;
    private List<BlogPostCommentDto> blogPostComments = new ArrayList<>();


    private String newBlogPostComment;

    @Inject
    private BlogController controller;

    /**
     * Constructor
     */
    public BlogPostBean() {


    }

    @PostConstruct
    private void init() {

        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        // it came from a click in bloglist page
        if(!params.isEmpty()) {
            if(params.get("blogPostId") != null) {
                blogPostId = Integer.parseInt(params.get("blogPostId"));

                BlogPostDto blogPostDto = controller.getBlogPost(blogPostId);
                blogPostTitle = blogPostDto.getTitle();
                blogPostContent = blogPostDto.getContent();

                blogPostComments = blogPostDto.getBlogPostComments();

            }
        }

    }


    public int getBlogPostId() {

        return blogPostId;
    }

    public void setBlogPostId(int blogPostId) {
        this.blogPostId = blogPostId;
    }

    public String getBlogPostTitle() {
        return blogPostTitle;
    }

    public void setBlogPostTitle(String blogPostTitle) {
        this.blogPostTitle = blogPostTitle;
    }

    public String getBlogPostContent() {
        return blogPostContent;
    }

    public void setBlogPostContent(String blogPostContent) {
        this.blogPostContent = blogPostContent;
    }

    public List<BlogPostCommentDto> getBlogPostComments() {
        return blogPostComments;
    }


    public void setBlogPostComments(List<BlogPostCommentDto> blogPostComments) {
        this.blogPostComments = blogPostComments;
    }

    public String getNewBlogPostComment() {
        return newBlogPostComment;
    }

    public void setNewBlogPostComment(String newBlogPostComment) {
        this.newBlogPostComment = newBlogPostComment;
    }

    public void addBlogComment(int blogPostId) {
        BlogPostCommentDto blogPostCommentDto = new BlogPostCommentDto();
        blogPostCommentDto.setComment(newBlogPostComment);
        blogPostCommentDto.setCommentCreated(LocalDateTime.now());
        controller.addBlogPostComment(blogPostCommentDto, blogPostId);
    }


}
