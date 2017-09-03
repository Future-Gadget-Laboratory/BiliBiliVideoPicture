package com.smallclover.test;

/**
 * @author smallclover
 * @create 2017-09-03
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author smallclover
 * @create 2017-09-02
 */
public class TestJsoup {

    //测试视频编号av12300267
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://search.bilibili.com/all?keyword=av14065638").get();
            Elements elements = doc.select("li[class=video list av]");

            String picUrl = elements.get(0).getElementsByTag("img").attr("data-src");
            System.out.println(picUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
