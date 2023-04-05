package com.bodax.home.services;

import com.bodax.home.dtos.CategoryDto;
import com.bodax.home.domain.repository.CategoryRepository;
import com.bodax.home.dtos.CategoryPropertyDto;
import com.bodax.home.dtos.PropertyValuesDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAllCategories();
    }

    @Override
    public List<PropertyValuesDto> getPropertyValuesByCategory(String groupUrl) {
        return categoryRepository.getCharacteristicsValuesByCategory(groupUrl);
    }

    @Override
    public List<CategoryPropertyDto> getCategoryProperties(String groupUrl) {
        return categoryRepository.getCategoryProperties(groupUrl);
    }
}
