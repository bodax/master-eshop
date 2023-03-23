package com.bodax.home.services;

import com.bodax.home.dtos.EntryPageInfo;
import org.springframework.stereotype.Service;

@Service
public class PageInfoServiceImpl implements PageInfoService {

    private final CategoryService categoryService;

    public PageInfoServiceImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public EntryPageInfo getEntryPageInformation() {
        EntryPageInfo pageInfo = new EntryPageInfo();
        pageInfo.setCategories(categoryService.getAllCategories());

        return pageInfo;
    }
}
