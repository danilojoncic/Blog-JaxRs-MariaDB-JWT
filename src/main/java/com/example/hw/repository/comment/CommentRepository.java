package com.example.hw.repository.comment;

import com.example.hw.domain.Comment;
import com.example.hw.repository.MDBAbstractRepository;

import java.util.List;

public class CommentRepository extends MDBAbstractRepository implements CommentRepositoryInterface {
    @Override
    public List<Comment> findCommentsForPost(Integer postId) {
        return null;
    }

    @Override
    public Comment addComment(Comment comment) {
        return null;
    }
}
