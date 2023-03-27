package com.bodax.home.domain.repository;

import com.bodax.home.domain.entity.Category;
import com.bodax.home.dtos.PropertyDto;

import java.util.List;

public interface CategoryRepository {

    List<Category> findAllCategories();



    List<PropertyDto> getCharacteristicsValuesByCategory (String groupUrl);

}
