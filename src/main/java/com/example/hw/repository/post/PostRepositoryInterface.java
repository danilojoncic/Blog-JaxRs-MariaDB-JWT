package com.example.hw.repository.post;

import com.example.hw.domain.Post;

import java.util.List;

public interface PostRepositoryInterface {
    public Post addPost(Post post);
    public List<Post> getAllPosts();
    public Post findPostById(Integer id);
}
