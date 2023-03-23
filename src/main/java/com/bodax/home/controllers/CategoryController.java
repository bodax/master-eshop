package com.bodax.home.controllers;

import com.bodax.home.domain.entity.Category;
import com.bodax.home.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("api/v1/category/{id}")
    public Category getCategories(@PathVariable Long id) {
        return categoryService.findCategoryById(id);
    }

}
