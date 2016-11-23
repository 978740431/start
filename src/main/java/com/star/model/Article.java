package com.star.model;

import java.sql.Date;

/**
 * Created by admin on 2016/7/7.
 */
public class Article {


    private int id;
    private String title;
    private String author;
    private Date createTime;
    private String content;
    private int price;
    private int uid;
    private boolean isDelete;
    private String articleGeneralize;
    private int articleLength;
    private int readTimes;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getArticleGeneralize() {
        return articleGeneralize;
    }

    public void setArticleGeneralize(String articleGeneralize) {
        this.articleGeneralize = articleGeneralize;
    }

    public int getArticleLength() {
        return articleLength;
    }

    public void setArticleLength(int articleLength) {
        this.articleLength = articleLength;
    }

    public int getReadTimes() {
        return readTimes;
    }

    public void setReadTimes(int readTimes) {
        this.readTimes = readTimes;
    }
}
