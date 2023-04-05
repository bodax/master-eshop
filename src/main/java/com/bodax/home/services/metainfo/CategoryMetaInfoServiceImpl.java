package com.bodax.home.services.metainfo;

import com.bodax.home.domain.repository.CategoryRepository;
import com.bodax.home.dtos.CategoryMetaInfoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryMetaInfoServiceImpl implements CategoryMetaInfoService {

    private final CategoryRepository categoryRepository;

    public CategoryMetaInfoServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryMetaInfoDto> getMetaInfo(String group) {
        return categoryRepository.getCategoryMetaInfo(group);
    }
}
