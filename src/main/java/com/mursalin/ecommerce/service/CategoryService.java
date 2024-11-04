package com.mursalin.ecommerce.service;

import com.mursalin.ecommerce.model.Category;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    ResponseEntity<String> createCategory(Category category);

    ResponseEntity<List<Category>> getCategories();

    ResponseEntity<Category> updateCategory(long id, Category category);

    ResponseEntity<String> deleteCategory(long id);
}
