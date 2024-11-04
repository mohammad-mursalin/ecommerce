package com.mursalin.ecommerce.serviceImp;

import com.mursalin.ecommerce.model.Category;
import com.mursalin.ecommerce.repository.CategoryRepository;
import com.mursalin.ecommerce.service.CategoryService;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService {

    private CategoryRepository repo;

    public CategoryServiceImp(CategoryRepository repo) {
        this.repo = repo;
    }

    @Override
    public ResponseEntity<String> createCategory(Category category) {
        if(category != null) {
            repo.save(category);
            return new ResponseEntity<>("new category added", HttpStatus.CREATED);
        }
        else
            return new ResponseEntity<>("couldn't add new category because of null category",HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = repo.findAll();
        return new ResponseEntity<>(categories, HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<Category> updateCategory(long id, Category category) {
        Optional<Category> savedCategory = repo.findById(id);
        if(savedCategory.isPresent()) {
            category.setId(id);
            repo.save(category);
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<String> deleteCategory(long id) {
        if(repo.existsById(id)) {
            repo.deleteById(id);
            return new ResponseEntity<>("category deleted with id " + id,HttpStatus.GONE);
        }
        return new ResponseEntity("category not found with id " + id, HttpStatus.NOT_FOUND);
    }
}
