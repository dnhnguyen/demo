package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // define custom methods if needed
}