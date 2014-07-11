package com.twu.biblioteca.model;

/**
 * User: gongming
 * Date: 7/11/14
 * Time: 8:32 AM
 * Email:gongmingqm10@foxmail.com
 */
public class Book{
    private String name;
    private String author;
    private String publishYear;

    public Book(String name, String author, String publishYear) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }
}
