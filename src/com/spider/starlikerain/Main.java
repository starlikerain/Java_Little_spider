package com.spider.starlikerain;

import com.spider.starlikerain.activity.RandomString;
import com.spider.starlikerain.model.NewsWithRelated;
import com.spider.starlikerain.model.UrlNews;
import com.spider.starlikerain.model.UrlNewsReader;
import com.spider.starlikerain.model.Viewable;
import com.spider.starlikerain.view.ListViewer;


import java.io.IOException;
import java.util.*;

public class Main {

    static final int maximumURL = 10; // 最多访问多少个 url

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis(); // 当前时间毫秒数

        Queue<NewsWithRelated> newsQueue = new LinkedList<NewsWithRelated>(); // 记录一个 NewsWithRelated hashMap 类型的列表 数据结构为 title, url

        String startUrl = "https://readhub.cn/topic/7OiKBs8TcLA";
        NewsWithRelated startNews = UrlNewsReader.read(startUrl); // 获得了一个 hashMap<title, url>

        int count = 0; // 弄一个什么计数器
        Set<String> visitedUrl = new HashSet<>(); // 弄一个 hashMap 记录需要访问过的 url
        visitedUrl.add(startUrl);

        newsQueue.add(startNews);


        startUrl = "https://readhub.cn/topic/5bMmlAm75lD";
        startNews = UrlNewsReader.read(startUrl); // 获得了一个 hashMap<title, url>

        visitedUrl.add(startUrl);

        newsQueue.add(startNews);


        ArrayList<Viewable> results = new ArrayList<>(); // Viewable 只是一个 interface 有 display
        while (!newsQueue.isEmpty() && count <= maximumURL) {
            NewsWithRelated current = newsQueue.poll(); // 抓取队列第一个新闻
            results.add(current); // 往 ArrayList 里面加当前第一个
            count++;
            for (Map.Entry<String, String> entry : current.getRelateds().entrySet()) {
                String url = entry.getValue(); // 这里 enrty 是单个 hashMap<String title, String url>;
                NewsWithRelated next = UrlNewsReader.read(url);
                if (!visitedUrl.contains(url)) { // 考虑不重复
                    newsQueue.add(next);
                    visitedUrl.add(url);
                }
            }
        }

        long endTime = System.currentTimeMillis();

        new ListViewer(results).display();

        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
}
