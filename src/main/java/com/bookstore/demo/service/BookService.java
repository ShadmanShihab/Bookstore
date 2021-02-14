package com.bookstore.demo.service;

import com.bookstore.demo.model.Book;
import com.bookstore.demo.model.Category;
import com.bookstore.demo.model.GetBookByPriceRange;
import com.bookstore.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class BookService {


    BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public boolean addNewBook(Book book) {
        try {
            bookRepository.save(book);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Book> getAllBooks() {
        List<Book> data = bookRepository.findAll();
        if (data.size() != 0) {
            return data;
        } else {
            return data;
        }
    }

    public List<Book> getBookByCategoryName(String categoryName) {
        try {
            List<Book> data = bookRepository.findByCategoryName(categoryName);
            if (data.size() != 0)
                return data;

            return data;

        } catch (Exception e) {
            return Arrays.asList(new Book());
        }

    }


    //get book by writer's name
    public List<Book> getBookByWritersName(String writersName) {
        List<Book> data = bookRepository.findByWritersName(writersName);

        if (data.size() != 0)
            return data;

        return data;
    }

    public List<Book> getBookListWithinPriceRange(GetBookByPriceRange getBookByPriceRange) {
        //return  bookRepository.priceRange(getBookByPriceRange);

        try {
            //storing all book data in a list
            List<Book> bookData = bookRepository.findAll();

            if (bookData.size() == 0) {
                return bookData;
            }
            //an empty list to store required books
            List<Book> requiredBooks = new LinkedList<Book>();
            //Index for requiredBooks
            Integer index = 0;
            for (int i = 0; i < bookData.size(); i++) {
                Book b = bookData.get(i);

                if (b.getPrice() >= getBookByPriceRange.getLowerLimit() && b.getPrice() <= getBookByPriceRange.getUpperLimit()) {
                    requiredBooks.add(index, bookData.get(i));
                    index = index + 1;
                }
            }
            return requiredBooks;
        } catch (Exception e) {
            return Arrays.asList(new Book());
        }
    }

}
