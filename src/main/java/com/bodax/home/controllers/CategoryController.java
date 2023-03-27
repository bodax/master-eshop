package com.bodax.home.controllers;

import com.bodax.home.dtos.CategoryPageInfoDto;
import com.bodax.home.services.CategoryService;
import com.bodax.home.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    private final CategoryService categoryService;
    private final ProductService productService;

    public CategoryController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping("/api/page/category-properties")
    public CategoryPageInfoDto getCategoriesProperties(@RequestParam String groupUrl, @RequestParam String lan) {
        CategoryPageInfoDto categoryInfo = new CategoryPageInfoDto();
        categoryInfo.setRelatedProducts(productService.getRelationOfAllCategoryProducts(groupUrl));
        categoryInfo.setValues(categoryService.getCharacteristicsValuesByCategory(groupUrl));

        return categoryInfo;

               /* relatedProducts: rows[0],
                values: rows[1],
                characteristics: rows[2],
                manufacturers: rows[3],
                meta: rows[4]*/
    }
}
