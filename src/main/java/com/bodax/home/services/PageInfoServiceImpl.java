package com.bodax.home.services;

import com.bodax.home.dtos.EntryPageInfoDto;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PageInfoServiceImpl implements PageInfoService {

    private final CategoryService categoryService;
    private final ProductService productService;

    public PageInfoServiceImpl(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public EntryPageInfoDto getEntryPageInformation(Set<Integer> watchedProductIds) {
        var pageInfo = new EntryPageInfoDto();
        pageInfo.setCategories(categoryService.getAllCategories());
        pageInfo.setDiscountProducts(productService.getDiscountProducts());
        pageInfo.setNewProducts(productService.getNewProducts());
        pageInfo.setWatchedProducts(productService.getProductsByIds(watchedProductIds));
        // pageInfo.setProductNews(productService.getProductNews());

        return pageInfo;
    }
}
