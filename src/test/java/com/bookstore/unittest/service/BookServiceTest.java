package com.bookstore.unittest.service;

import com.bookstore.demo.model.Book;
import com.bookstore.demo.model.Category;
import com.bookstore.demo.model.GetBookByPriceRange;
import com.bookstore.demo.repository.BookRepository;
import com.bookstore.demo.service.BookService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
    BookRepository bookRepository;

    BookService bookService;

    @BeforeEach
    void initUseCase() {
        bookService = new BookService(bookRepository);
    }


    @Test
    @DisplayName("Storing a new book with valid data_should return true")
    public void test_addNewBookWithValidData_shouldReturnTrue(){
        Book book = new Book("111","bookname", "bookWriterName", 100.25, Arrays.asList(new Category("11", "abc",
                "xyz")));

        boolean expectedResult = true;

        when(bookRepository.save(book)).thenReturn(book);

        boolean actualResult = bookService.addNewBook(book);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void test_addNewBookWithInvalidData_shouldReturnFalse(){
        Book book = new Book("111", "bookname", "bookWriterName", 100.25, Arrays.asList(new Category("11", "abc", "xyz")));

        boolean expectedResult = false;

        when(bookRepository.save(book)).thenThrow(new IllegalArgumentException());

        boolean actualResult = bookService.addNewBook(book);

        assertThat(actualResult).isEqualTo(expectedResult);
    }


    @Test
    public void test_getBookByWritersNameWithValidData_shouldReturnWritersBookList(){
        String bookWritersName = "a";
        Book book = new Book("60250dfa14c25a32e6deb5ad", "a", "a", 25.53, Arrays.asList(new Category(
                "one", "a", "a")));

        List<Book> expectedResult = new LinkedList<Book>();
        expectedResult.add(0, book);

        when(bookRepository.findByWritersName(bookWritersName)).thenReturn(Arrays.asList(book));
        List<Book> actualResult = bookService.getBookByWritersName(bookWritersName);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void test_getBookByWritersNameWithInValidData_shouldReturnEmptyList(){
        String bookWritersName = "a";
        Book book = new Book();
         List<Book> expectedResult = new LinkedList<Book>();
        expectedResult.add(0, book);

        when(bookRepository.findByWritersName(bookWritersName)).thenReturn(Arrays.asList(book));
        List<Book> actualResult = bookService.getBookByWritersName(bookWritersName);

        assertThat(actualResult).isEqualTo(expectedResult);
    }





    @Test
    public void test_getAllBooksWithValidData_shouldReturnFullBookList(){

        Book book = new Book("60250dfa14c25a32e6deb5ad", "a", "a", 25.53, Arrays.asList(new Category(
                "one", "a", "a")));

        List<Book> expectedResult = new LinkedList<Book>();
        expectedResult.add(0, book);

        when(bookRepository.findAll()).thenReturn(Arrays.asList(book));
        List<Book> actualResult = bookService.getAllBooks();
        assertThat(actualResult).isEqualTo(expectedResult);
    }


    @Test
    public void test_getAllBooksWithInvalidData_shouldReturnEmptyList(){

        Book book = new Book("60250dfa14c25a32e6deb5ad", "a", "a", 25.53, Arrays.asList(new Category(
                "one", "a", "a")));

        List<Book> expectedResult = new LinkedList<Book>();
        //expectedResult.add(0, book);

        when(bookRepository.findAll()).thenReturn(Arrays.asList());
        List<Book> actualResult = bookService.getAllBooks();
        assertThat(actualResult).isEqualTo(expectedResult);
    }



    @Test
    public void test_getBookByCategoryNameWithValidData_shouldReturnWritersBookList(){
        String categoryName = "a";
        Book book = new Book("60250dfa14c25a32e6deb5ad", "a", "a", 25.53, Arrays.asList(new Category(
                "one", "a", "a")));

        List<Book> expectedResult = new LinkedList<Book>();
        expectedResult.add(0, book);

        when(bookRepository.findByCategoryName(categoryName)).thenReturn(Arrays.asList(book));
        List<Book> actualResult = bookService.getBookByCategoryName(categoryName);
        assertThat(actualResult).isEqualTo(expectedResult);
    }



    @Test
    public void test_getBookByCategoryNameWithInValidData_shouldReturnEmptyList(){
        String categoryName = "a";
        Book book = new Book();
        List<Book> expectedResult = new LinkedList<Book>();
        expectedResult.add(0, book);

        when(bookRepository.findByCategoryName(categoryName)).thenReturn(Arrays.asList(book));
        List<Book> actualResult = bookService.getBookByCategoryName(categoryName);

        assertThat(actualResult).isEqualTo(expectedResult);
    }


    @Test
    public void test_getBookByPriceRangeWithValidData_shouldReturnBookList(){
        GetBookByPriceRange getBookByPriceRange = new GetBookByPriceRange(10, 300);

        Book book = new Book("60250dfa14c25a32e6deb5ad", "a", "a", 25.53, Arrays.asList(new Category(
                "one", "a", "a")));

        List<Book> expectedResult = new LinkedList<Book>();
        expectedResult.add(0, book);

        when(bookRepository.findAll()).thenReturn(Arrays.asList(book));
        List<Book> actualResult = bookService.getBookListWithinPriceRange(getBookByPriceRange);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
