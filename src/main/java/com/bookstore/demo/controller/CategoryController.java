package com.bookstore.demo.controller;

import com.bookstore.demo.model.Category;
import com.bookstore.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/")
    public String home(){
        return "Welcome to the home page";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/categories")
    public boolean addCategories(@RequestBody Category category){
        return categoryService.addNewCategories(category);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/categories")
    public List<Category> getCategories(){
        return categoryService.getAllCategories();
    }
}
