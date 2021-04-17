package com.example.newsapp.data;

public class Story {

    String section;
    String title;
    String author;
    String publishedDate;
    String type;
    String webUrl;

    public Story(String section, String title, String type){
        this.section = section;
        this.title = title;
        this.type = type;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
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

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public boolean hasType(){
        return type!=null;
    }
    public boolean hasAuthor(){
        return author!=null;
    }
    public boolean hasPublishedDate(){
        return publishedDate!=null;
    }
    @Override
    public String toString() {
        return "Story{" +
                "section='" + section + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", type='" + type + '\'' +
                '}';
    }


}
