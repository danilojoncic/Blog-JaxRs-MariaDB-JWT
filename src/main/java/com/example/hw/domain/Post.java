package com.example.hw.domain;

public class Post {

    private int id;
    //u sustini strani kljud na usera jer user gledamo po username
    private String authorName;
    private String title;
    private String content;

    public Post() {
    }

    public Post(String authorName, String title, String content) {
        this.authorName = authorName;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
