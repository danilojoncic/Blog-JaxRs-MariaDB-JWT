package com.example.hw.service;

import com.example.hw.domain.Comment;
import com.example.hw.dto.CommentDTO;
import com.example.hw.repository.comment.CommentRepositoryInterface;
import com.example.hw.repository.user.UserRepositoryInterface;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class CommentService {
    public CommentService() {
        System.out.println(this);
    }

    @Inject
    private CommentRepositoryInterface commentRepository;
    @Inject
    private UserRepositoryInterface userRepositoryInterface;

    //
    public void addComment(CommentDTO comment) {
        commentRepository.addComment(comment);
    }

    public List<CommentDTO> allComments(int id) {
        List<Comment> comments =  this.commentRepository.findCommentsForPost(id);
        List<CommentDTO> dto = new ArrayList<>();
        for (Comment comment : comments) {
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setPost_id(comment.getId());
            commentDTO.setText(comment.getContent());
            commentDTO.setAuthor(this.userRepositoryInterface.findById(comment.getAuthorId()).getName());
            dto.add(commentDTO);
        }
        return dto;
    }

}
