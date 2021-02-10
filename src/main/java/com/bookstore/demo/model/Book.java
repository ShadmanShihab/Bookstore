package com.bookstore.demo.model;

import java.util.List;

public class Book {
    private String id;
    private String bookName;
    private String bookWriterName;
    private double price;
    private List<Category> category;
    public GetBookByPriceRange getBookByPriceRange;

    public Book() {
    }

    public Book(String id, String bookName, String bookWriterName, double price, List<Category> category) {
        this.id = id;
        this.bookName = bookName;
        this.bookWriterName = bookWriterName;
        this.price = price;
        this.category = category;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookWriterName() {
        return bookWriterName;
    }

    public void setBookWriterName(String bookWriterName) {
        this.bookWriterName = bookWriterName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }
}
