package com.example.hw.domain;

public class Comment {
    private int id;
    private int authorId;
    private String content;
    private int postId;

    public Comment() {
    }

    public Comment(int author, String content) {
        this.authorId = author;
        this.content = content;
    }

    public Comment(int id, int postId, int author,String content) {
        this.id = id;
        this.authorId = author;
        this.content = content;
        this.postId = postId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }


    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
