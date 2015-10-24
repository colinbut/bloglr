/*
 * |-------------------------------------------------
 * | Copyright &copy; 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.controller.dto;

import java.time.LocalDateTime;

/**
 * Viewmodel DTO for Blog Post comment
 *
 * @author colin
 */
public class BlogPostCommentDto {

    private String comment;
    private LocalDateTime commentCreated;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCommentCreated() {
        return commentCreated;
    }

    public void setCommentCreated(LocalDateTime commentCreated) {
        this.commentCreated = commentCreated;
    }


    @Override
    public String toString() {
        return "BlogPostCommentDto{" +
                "comment='" + comment + '\'' +
                ", commentCreated=" + commentCreated +
                '}';
    }
}
