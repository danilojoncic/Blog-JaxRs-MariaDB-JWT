package com.example.hw.domain;

public class Comment {
    private int id;
    private int author;
    private String content;
    private int postId;

    public Comment() {
    }

    public Comment(int author, String content) {
        this.author = author;
        this.content = content;
    }

    public Comment(int id, int postId, int author,String content) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.postId = postId;

    }



    public int getPostId() {
        return postId;
    }


    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
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
