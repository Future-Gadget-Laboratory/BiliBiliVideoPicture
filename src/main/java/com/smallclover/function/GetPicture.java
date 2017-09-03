package com.smallclover.function;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author smallclover
 * @create 2017-09-04
 */
public class GetPicture {

    public static String getPictureByAvNum(String avNum) throws IOException {
        Document doc = Jsoup.connect("https://search.bilibili.com/all?keyword="+avNum).get();
        Elements elements = doc.select("li[class=video list av]");

        String picUrl = elements.get(0).getElementsByTag("img").attr("data-src");
        return picUrl;
    }
}
