package com.bookstore.demo.controller;

import com.bookstore.demo.model.Book;
import com.bookstore.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    //Add new book
    @PostMapping
    public boolean addBook(@RequestBody Book book){
        return bookService.addNewBook(book);
    }

    //get books
    @GetMapping
    public List<Book> getbooks(){
        return bookService.getAllBooks();
    }


    //get books by category
    @GetMapping("/categories/{categoryName}")
    public List<Book> getBookByCategoryName(@PathVariable String categoryName){
        return bookService.getBookByCategoryName(categoryName);
    }


    //Search Book by writer's name
    @GetMapping("/writers/{writersName}")
    public List<Book> getBookByWritersName(@PathVariable String writersName){
        List<Book> bookByWritersName = bookService.getBookByWritersName(writersName);
        return bookByWritersName;
    }
}
