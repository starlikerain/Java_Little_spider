package com.spider.starlikerain.model;

public class News implements Viewable {
    private String title;
    private String content;

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // TODO 这里我写了 this.
    public String getTitle() {
        return this.title;
    }

    // TODO 这里我写了 this.
    public String getContent() {
        return this.content;
    }


    @Override
    public void display() {
        System.out.println("|title|" + this.getTitle());
        System.out.println("|content|" + this.getContent());
    }
}
