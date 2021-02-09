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

        List<Book> data = bookRepository.findAll();
        System.out.println(data);
        Integer ans = null;
        List<Book> llist = new LinkedList<Book>();

        for(int i=0; i<data.size(); i++){
            Book b = data.get(i);
            System.out.println(b.getBookName());
            Category c = b.getCategory();

            if(c.getCategoryName().equals(category)){
                ans = i;
                break;
            }
        }
        llist.add(0, data.get(ans));
        return llist;
    }
}
