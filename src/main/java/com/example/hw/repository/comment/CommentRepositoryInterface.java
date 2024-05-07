package com.example.hw.repository.comment;

import com.example.hw.domain.Comment;

import java.util.List;

public interface CommentRepositoryInterface {
    public List<Comment> findCommentsForPost(Integer postId);
    public Comment addComment(Comment comment);
}
