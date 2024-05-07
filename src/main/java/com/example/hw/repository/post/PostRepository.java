package com.example.hw.repository.post;

import com.example.hw.domain.Post;
import com.example.hw.repository.MDBAbstractRepository;

import java.util.List;

public class PostRepository extends MDBAbstractRepository implements PostRepositoryInterface {

    @Override
    public Post addPost(Post post) {
        return null;
    }

    @Override
    public List<Post> getAllPosts() {
        return null;
    }

    @Override
    public Post findPostById(Integer id) {
        return null;
    }
}
