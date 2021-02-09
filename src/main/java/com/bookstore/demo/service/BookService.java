package com.bookstore.demo.service;

import com.bookstore.demo.model.Book;
import com.bookstore.demo.model.Category;
import com.bookstore.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
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

    public List<Book> getBookByCategoryName(String category) {

        //all books are stored in a list
        List<Book> data = bookRepository.findAll();

        //empty list to store required books
        List<Book> llist = new LinkedList<Book>();

        //index of required books list
        int index = 0;

        for(int i=0; i<data.size(); i++){
            Book b = data.get(i);
            Category c = b.getCategory();

            if(c.getCategoryName().equals(category)){
                llist.add(index, data.get(i));
                index = index + 1;
            }
        }
        return llist;
    }
}
