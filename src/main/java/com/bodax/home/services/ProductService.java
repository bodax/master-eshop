package com.bodax.home.services;

import com.bodax.home.dtos.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getProductByCategory (String groupUrl);

    List<ProductDto> getRelationOfAllCategoryProducts(String groupUrl);
}
