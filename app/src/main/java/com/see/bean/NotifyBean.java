package com.see.bean;

import java.io.Serializable;

/**
 * Created by see on 2017/5/9.
 */
public class NotifyBean implements Serializable{
    String author;
    String time;
    String content;
    String title;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String theme) {
        this.title = theme;
    }

    @Override
    public String toString() {
        return "NotifyBean{" +
                "author='" + author + '\'' +
                ", time='" + time + '\'' +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
