package com.bodax.home.services;

import com.bodax.home.domain.entity.Category;

import java.util.List;

public interface CategoryService {

    Category findCategoryById (Long categoryId);

    List<Category> getAllCategories();

}
