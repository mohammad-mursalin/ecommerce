package com.mursalin.ecommerce.controller;

import com.mursalin.ecommerce.model.Category;
import com.mursalin.ecommerce.service.CategoryService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/user/categories")
    public ResponseEntity<List<Category>> getCategories() {
        return service.getCategories();
    }

    @PutMapping("/admin/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable long id, @RequestBody Category category) {
        return service.updateCategory(id,category);
    }
}
