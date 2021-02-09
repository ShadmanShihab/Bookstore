package com.bookstore.demo.controller;

import com.bookstore.demo.model.Book;
import com.bookstore.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    //Add new book
    @RequestMapping(method = RequestMethod.POST, value = "/books")
    public boolean addBook(@RequestBody Book book){
        return bookService.addNewBook(book);
    }

    //get books
    @RequestMapping(method = RequestMethod.GET, value = "/books")
    public List<Book> getbooks(){
        return bookService.getAllBooks();
    }


    //get books by category
    @RequestMapping(method = RequestMethod.GET, value = "/books/{categoryName}")
    public List<Book> getBookByCategoryName(@PathVariable String categoryName){
        return bookService.getBookByCategoryName(categoryName);
    }


    //Search Book by writer's name
//    @RequestMapping(method = RequestMethod.GET, value = "/books/{writersName}")
//    public List<Book> getBookByWritersName(@PathVariable String writersName){
//        return bookService.getBookByWritersName(writersName);
//    }
}
