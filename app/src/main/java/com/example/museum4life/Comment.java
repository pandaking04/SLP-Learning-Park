package com.example.museum4life;

public class Comment {

    public String username,text;

    public Comment(String username, String text) {
        this.username = username;
        this.text = text;
    }

    public String getName() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
    }

    public String getComment_txt() {
        return text;
    }

    public void setComment_txt(String text) {
        this.text = text;
    }

    public Comment() {}
}
