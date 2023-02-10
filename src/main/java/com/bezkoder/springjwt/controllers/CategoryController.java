package com.bezkoder.springjwt.controllers;
import java.util.List;

import javax.validation.Valid;

import com.bezkoder.springjwt.models.Post;
import com.bezkoder.springjwt.service.CategoryService;
import com.bezkoder.springjwt.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.bezkoder.springjwt.models.Category;
@RestController
@RequestMapping("/api/categories")
@PreAuthorize("hasRole('ADMIN')")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable(value = "id") Long categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @PostMapping
    public Category createCategory(@Valid @RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable(value = "id") Long categoryId,
                                   @Valid @RequestBody Category categoryDetails) {
        return categoryService.updateCategory(categoryId, categoryDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable(value = "id") Long categoryId) {
        return categoryService.deleteCategory(categoryId);
    }

    @GetMapping("/{id}/posts")
    public List<Post> getPostsByCategory(@PathVariable(value = "id") Long categoryId) {
        return postService.getPostsByCategory(categoryId);
    }

}