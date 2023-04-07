package com.bodax.home.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class EntryPageInfoDto {
    private List<CategoryDto> categories;
    private List<ProductDto> discountProducts;
    private List<ProductDto> newProducts;
    private List<?> productNews;
    private List<ProductDto> watchedProducts = new ArrayList<>();

}
