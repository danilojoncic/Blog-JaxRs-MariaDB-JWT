package com.example.hw.service;

import com.example.hw.domain.Post;
import com.example.hw.dto.PostDTO;
import com.example.hw.repository.post.PostRepositoryInterface;
import com.example.hw.repository.user.UserRepositoryInterface;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class PostService {
    public PostService() {
        System.out.println(this);
    }

    @Inject
    private PostRepositoryInterface postRepository;
    @Inject
    private UserRepositoryInterface userRepositoryInterface;

    //
    public Post addPost(Post post) {
        return this.postRepository.addPost(post);
    }
    public List<PostDTO> allPosts() {
        List<Post> posts =  this.postRepository.getAllPosts();
        List<PostDTO> postDTOS = new ArrayList<>();
        for (Post post : posts) {
            PostDTO postDTO = new PostDTO();
            postDTO.setText(post.getContent());
            postDTO.setAuthor(userRepositoryInterface.findById(post.getAuthorId()).getName());
            postDTO.setTitle(post.getTitle());
            postDTO.setDate(post.getDate());
            postDTO.setPostId(post.getId());
            postDTOS.add(postDTO);
        }
        return postDTOS;
    }

    public PostDTO findPost(int postId) {
        Post post =  this.postRepository.findPostById(postId);
        PostDTO postDTO = new PostDTO();
        postDTO.setText(post.getContent());
        postDTO.setAuthor(userRepositoryInterface.findById(post.getAuthorId()).getName());
        postDTO.setTitle(post.getTitle());
        postDTO.setDate(post.getDate());
        postDTO.setPostId(post.getId());
        return postDTO;
    }
}
