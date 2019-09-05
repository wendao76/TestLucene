package com.github.wendao76.data;

import com.github.wendao76.model.Article;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {
    /**
     * 获取文章列表数据
     * @return
     */
    public static List<Article> getAricleList() {
        List<Article> articles = new ArrayList<>();

        Article article = new Article(100L, "测试标题，文字随意", "文章内容，长度是没有限制的", "wendao76", "https://gitee.com/jianggujin/IKAnalyzer-lucene");
        articles.add(article);


        return articles;
    }
}
