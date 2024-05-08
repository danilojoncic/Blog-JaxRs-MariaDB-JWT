package com.example.hw.service;

import com.example.hw.domain.Post;
import com.example.hw.repository.post.PostRepositoryInterface;

import javax.inject.Inject;
import java.util.List;

public class PostService {
    public PostService() {
        System.out.println(this);
    }

    @Inject
    private PostRepositoryInterface postRepository;

    //
    public Post addPost(Post post) {
        return this.postRepository.addPost(post);
    }
    public List<Post> allPosts() {
        return this.postRepository.getAllPosts();}

    public Post findPost(int postId) {
        return this.postRepository.findPostById(postId);
    }
}
