package com.spider.starlikerain.model;

import java.util.HashMap;
import java.util.Map;

public class NewsWithRelated extends UrlNews {
    private HashMap<String, String> relateds = new HashMap<>();

    public NewsWithRelated(String url, String title, String content) {
        super(url, title, content);
    }

    public void addRelated(String title, String url) { // 把 title 和 url 放到 hashMap 中
        this.relateds.put(title, url);
    }

    public HashMap getRelateds() {
        return this.relateds;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("|related|");
        for (Map.Entry<String, String> entry : this.relateds.entrySet()) { // 对 hashMap.entrySet 实例进行遍历
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
