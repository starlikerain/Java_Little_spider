package com.spider.starlikerain.model;

public class News implements Viewable {
    public String title;
    public String content;

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }


    @Override
    public void display() {
        System.out.println("|title|" + this.getTitle());
        System.out.println("|content|" + this.getContent());
    }
}
