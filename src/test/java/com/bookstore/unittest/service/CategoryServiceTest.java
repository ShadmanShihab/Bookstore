package com.bookstore.unittest.service;

import com.bookstore.demo.model.Category;
import com.bookstore.demo.repository.CategoryRepository;
import com.bookstore.demo.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
    @Mock
    CategoryRepository categoryRepository;

    CategoryService categoryService;

    @BeforeEach
    void initUseCase(){
        categoryService = new CategoryService(categoryRepository);
    }


    @Test
    public void testAddNewCategoryWithValidData_shouldReturnTrue(){
        Category category = new Category("six", "Adventure2", "Adventure2101");
        boolean expectedResult = true;

        when(categoryRepository.save(category)).thenReturn(category);
        boolean actualResult = categoryService.addNewCategories(category);

        assertThat(actualResult).isEqualTo(expectedResult);

    }

    @Test
    public void testAddNewCategoryWithInvalidData_shouldReturnFalse(){
        Category category = new Category("six", "Adventure2", "Adventure2101");
        boolean expectedResult = false;

        when(categoryRepository.save(category)).thenThrow(new IllegalArgumentException());
        boolean actualResult = categoryService.addNewCategories(category);

        assertThat(actualResult).isEqualTo(expectedResult);

    }


    @Test
    public void getAllCategores_shouldReturnFullListOfCategories(){
        Category category = new Category("six", "Adventure2", "Adventure2101");
        List<Category> expectedResult = new LinkedList<>();
        expectedResult.add(category);

        when(categoryRepository.findAll()).thenReturn(Arrays.asList(category));
        List<Category> actualResult = categoryService.getAllCategories();

        assertThat(actualResult).isEqualTo(expectedResult);

    }
}
