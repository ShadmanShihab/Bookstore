package com.bookstore.demo.service;

import com.bookstore.demo.model.Book;
import com.bookstore.demo.model.Category;
import com.bookstore.demo.model.GetBookByPriceRange;
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

    public List<Book> getBookByCategoryName(String categoryName) {

        return bookRepository.findByCategoryName(categoryName);
//
//        //all books are stored in a list
//        List<Book> data = bookRepository.findAll();
//
//        //empty list to store required books
//        List<Book> llist = new LinkedList<Book>();
//
//        //index of required books list
//        int index = 0;
//
//        for(int i=0; i<data.size(); i++){
//            Book b = data.get(i);
//            List<Category> c = b.getCategory();
//
//            for(int j=0; j<c.size(); j++){
//                if(c.get(j).getCategoryName().equals(category)){
//                    llist.add(index, data.get(i));
//                    index = index + 1;
//                }
//            }
//
//        }
   //     return llist;
    }


    //get book by writer's name
    public List<Book> getBookByWritersName(String writersName) {
        return bookRepository.findByWritersName(writersName);
//        //storing all book data in a list
//        List<Book> bookData = bookRepository.findAll();
//
//        //an empty list to store required books
//        List<Book> requiredBooks = new LinkedList<Book>();
//
//        //Index for requiredBooks
//        Integer index = 0;
//
//        for(int i=0; i<bookData.size(); i++){
//
//            Book currentBook = bookData.get(i);
//
//            if(currentBook.getBookWriterName().equals(writersName)){
//                requiredBooks.add(0, bookData.get(i));
//                //index = index + 1;
//            }
//        }
//        return  requiredBooks;
    }

    public List<Book> getBookListWithinPriceRange(GetBookByPriceRange getBookByPriceRange) {
        //return  bookRepository.priceRange(getBookByPriceRange);
                //storing all book data in a list
        List<Book> bookData = bookRepository.findAll();

        //an empty list to store required books
        List<Book> requiredBooks = new LinkedList<Book>();

        //Index for requiredBooks
        Integer index = 0;

        for(int i=0; i<bookData.size(); i++){
            Book b = bookData.get(i);

            if(b.getPrice() >= getBookByPriceRange.getLowerLimit() && b.getPrice() <= getBookByPriceRange.getUpperLimit()){
                requiredBooks.add(index, bookData.get(i));
                index = index + 1;
            }
        }
        return requiredBooks;
    }
}
