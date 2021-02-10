package com.bookstore.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Book {
    @Id
    private String id;
    private String bookName;
    private String bookWriterName;
    private double price;
    @DBRef
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
