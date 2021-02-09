package com.bookstore.demo.service;

import com.bookstore.demo.model.Category;
import com.bookstore.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Struct;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public boolean addNewCategories(Category category) {
        try{
            categoryRepository.save(category);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
