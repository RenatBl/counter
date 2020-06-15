package ru.itis.counter.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class PageSavingUtil {

    public static void savePage(String url) {
        URL pageUrl;
        Document page;

        try {
            pageUrl = new URL(url);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }

        try {
            page = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(getNewPath(pageUrl)));
            bos.write(page.outerHtml().getBytes());
            bos.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private static String getNewPath(URL url) {
        String path = url.getHost().split(".")[0];
        return "D:/" + path + ".html";
    }
}
