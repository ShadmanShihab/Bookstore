package com.bookstore.demo.service;

import com.bookstore.demo.model.Book;
import com.bookstore.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;


    public boolean addNewBook(Book book) {
        try{
            bookRepository.save(book);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
