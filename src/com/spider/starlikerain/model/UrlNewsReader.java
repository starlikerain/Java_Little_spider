package com.spider.starlikerain.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class UrlNewsReader {
    public static NewsWithRelated read(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
    }
}
