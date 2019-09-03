package com.github.wendao76.model;

import lombok.Data;
import org.apache.lucene.document.*;

@Data
public class Article {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String url;

    public Article() {

    }

    public Article(Long id, String title, String content, String author, String url) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.url = url;
    }

    /**
     * 生成Lucene存储的格式
     */
    public Document toDocument() {
        //Lucene存储的格式（Map装的k,v）
        Document doc = new Document();
        //向文档中添加一个long类型的属性，建立索引
        doc.add(new LongPoint("id", id));
        //在文档中存储
        doc.add(new StoredField("id", id));
        //设置一个文本类型，会对内容进行分词，建立索引，并将内容在文档中存储
        doc.add(new TextField("title", title, Field.Store.YES));
        //设置一个文本类型，会对内容进行分词，建立索引，存在文档中存储 / No代表不存储
        doc.add(new TextField("content", content, Field.Store.YES));
        //StringField，不分词，建立索引，文档中存储
        doc.add(new StringField("author", author, Field.Store.YES));
        //不分词，不建立索引，在文档中存储，
        doc.add(new StoredField("url", url));
        return doc;
    }

    /**
     * 解析Lucene存储的格式
     */
    public static Article parseArticle(Document doc) {
        Long id = Long.parseLong(doc.get("id"));
        String title = doc.get("title");
        String content = doc.get("content");
        String author = doc.get("author");
        String url = doc.get("url");
        return new Article(id, title, content, author, url);
    }
}