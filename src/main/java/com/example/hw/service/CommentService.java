package com.example.hw.service;

import com.example.hw.domain.Comment;
import com.example.hw.repository.comment.CommentRepositoryInterface;

import javax.inject.Inject;
import java.util.List;

public class CommentService {
    public CommentService() {
        System.out.println(this);
    }

    @Inject
    private CommentRepositoryInterface commentRepository;

    //
    public Comment addComment(Comment comment) {
        return this.commentRepository.addComment(comment);
    }

    public List<Comment> allComments(int id) {
        return this.commentRepository.findCommentsForPost(id);
    }

}
