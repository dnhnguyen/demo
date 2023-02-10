package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.models.Category;
import com.bezkoder.springjwt.repository.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long categoryId, Category category) {
        return categoryRepository.save(category);
    }

    public ResponseEntity<Object> deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        return null;
    }
}
