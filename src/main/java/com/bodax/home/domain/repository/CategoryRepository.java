package com.bodax.home.domain.repository;

import com.bodax.home.dtos.CategoryDto;
import com.bodax.home.dtos.CategoryMetaInfoDto;
import com.bodax.home.dtos.CategoryPropertyDto;
import com.bodax.home.dtos.PropertyValuesDto;

import java.util.List;

public interface CategoryRepository {

    List<CategoryDto> findAllCategories();

    List<PropertyValuesDto> getCharacteristicsValuesByCategory (String groupUrl);

    List<CategoryPropertyDto> getCategoryProperties(String groupUrl);

    List<CategoryMetaInfoDto> getCategoryMetaInfo(String groupUrl);
}
