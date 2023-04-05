package com.bodax.home.services;

import com.bodax.home.dtos.CategoryDto;
import com.bodax.home.dtos.CategoryPropertyDto;
import com.bodax.home.dtos.PropertyValuesDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAllCategories();

    List<PropertyValuesDto> getPropertyValuesByCategory(String groupUrl);

    List<CategoryPropertyDto> getCategoryProperties(String groupUrl);
}
