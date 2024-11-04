package com.mursalin.ecommerce.service;

import com.mursalin.ecommerce.model.Category;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

public interface CategoryService {

    ResponseEntity<String> createCategory(Category category);
}
