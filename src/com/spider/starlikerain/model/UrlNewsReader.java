package com.spider.starlikerain.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class UrlNewsReader {
    public static String content;
    public static NewsWithRelated read(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements titleElements = doc.select("title");
        String title = titleElements.first().text();
        content = doc.select("meta[name=description]").attr("content");

        NewsWithRelated news = new NewsWithRelated(url, title, content);

        Elements relatedElements = doc.select(".timeline__item___2eWUN");
        for (Element element : relatedElements) {
            String relatedTitle = element.select(".content-item___3KfMq").text();
            Elements children = element.children();
            String relatedUrl = children.get(3).child(0).absUrl("href");

            news.addRelated(relatedTitle, relatedUrl);
        }
        return news;
    }
}
