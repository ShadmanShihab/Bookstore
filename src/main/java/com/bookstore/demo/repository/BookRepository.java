package com.bookstore.demo.repository;

import com.bookstore.demo.model.Book;
import com.bookstore.demo.model.GetBookByPriceRange;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    @Query("{ 'category.categoryName' : ?0 }")
    List<Book> findByCategoryName(String categoryName);


    @Query("{ 'bookWriterName' : ?0 }")
    List<Book> findByWritersName(String bookWriterName);

    @Query(value = "{ 'getBookBypriceRange' : ?0 }")
    List<Book> priceRange(GetBookByPriceRange getBookByPriceRange);
}
