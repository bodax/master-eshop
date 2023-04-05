package com.bodax.home.controllers;

import com.bodax.home.dtos.CategoryPageInfoDto;
import com.bodax.home.services.CategoryService;
import com.bodax.home.services.ManufacturerService;
import com.bodax.home.services.ProductService;
import com.bodax.home.services.metainfo.CategoryMetaInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CategoryController {

    private final CategoryService categoryService;
    private final ProductService productService;
    private final ManufacturerService manufacturerService;
    private final CategoryMetaInfoService categoryMetaInfoService;

    public CategoryController(CategoryService categoryService, ProductService productService,
                              ManufacturerService manufacturerService, CategoryMetaInfoService categoryMetaInfoService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.manufacturerService = manufacturerService;
        this.categoryMetaInfoService = categoryMetaInfoService;
    }

    @GetMapping("/api/page/category-properties")
    public Map<String, CategoryPageInfoDto> getCategoriesProperties(@RequestParam String groupUrl, @RequestParam String lan) {
        CategoryPageInfoDto categoryInfo = new CategoryPageInfoDto();
        categoryInfo.setRelatedProducts(productService.getRelationOfAllCategoryProducts(groupUrl));
        categoryInfo.setValues(categoryService.getPropertyValuesByCategory(groupUrl));
        categoryInfo.setCharacteristics(categoryService.getCategoryProperties(groupUrl));
        categoryInfo.setManufacturers(manufacturerService.getManufacturersByCategoryUrl(groupUrl));
        categoryInfo.setCategoryMetaInfo(categoryMetaInfoService.getMetaInfo(groupUrl));

        return Map.of("categoryInfo", categoryInfo);
    }
}
