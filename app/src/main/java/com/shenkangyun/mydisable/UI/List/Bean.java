package com.shenkangyun.mydisable.UI.List;

/**
 * Created by Administrator on 2017/11/3.
 */

public class Bean {

    private String title;
    private String text;

    public Bean() {
    }

    public Bean(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
