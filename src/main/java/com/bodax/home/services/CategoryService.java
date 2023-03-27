package com.bodax.home.services;

import com.bodax.home.domain.entity.Category;
import com.bodax.home.dtos.PropertyDto;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    List<PropertyDto> getCharacteristicsValuesByCategory(String groupUrl);

}
