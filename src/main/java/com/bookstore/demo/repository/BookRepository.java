package com.bookstore.demo.repository;

import com.bookstore.demo.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
