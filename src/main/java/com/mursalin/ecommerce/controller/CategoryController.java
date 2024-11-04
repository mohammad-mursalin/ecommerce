package com.mursalin.ecommerce.controller;

import com.mursalin.ecommerce.model.Category;
import com.mursalin.ecommerce.service.CategoryService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping("/admin/category")
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
        return service.createCategory(category);
    }
}
