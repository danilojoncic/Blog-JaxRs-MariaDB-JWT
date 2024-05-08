package com.example.hw.domain;

public class Post {

    private int id;
    //u sustini strani kljud na usera jer user gledamo po username
    private int authorName;
    private String title;
    private String content;
    private String date;

    public Post() {
    }

    public Post(int authorName, String title, String content) {
        this.authorName = authorName;
        this.title = title;
        this.content = content;
    }

    public Post(int id, int authorName, String title, String content, String date) {
        this.id = id;
        this.authorName = authorName;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthorName() {
        return authorName;
    }

    public void setAuthorName(int authorName) {
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
