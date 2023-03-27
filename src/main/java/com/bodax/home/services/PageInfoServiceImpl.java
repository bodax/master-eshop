package com.bodax.home.services;

import com.bodax.home.dtos.EntryPageInfoDto;
import org.springframework.stereotype.Service;

@Service
public class PageInfoServiceImpl implements PageInfoService {

    private final CategoryService categoryService;

    public PageInfoServiceImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public EntryPageInfoDto getEntryPageInformation() {
        EntryPageInfoDto pageInfo = new EntryPageInfoDto();
        pageInfo.setCategories(categoryService.getAllCategories());

        return pageInfo;
    }
}
