package com.bodax.home.services;

import com.bodax.home.domain.entity.Category;
import com.bodax.home.domain.repository.CategoryRepository;
import com.bodax.home.dtos.PropertyDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAllCategories();
    }

    @Override
    public List<PropertyDto> getCharacteristicsValuesByCategory(String groupUrl) {
        return categoryRepository.getCharacteristicsValuesByCategory(groupUrl);
    }
}
