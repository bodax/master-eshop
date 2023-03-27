package com.bodax.home.domain.repository;

import com.bodax.home.dtos.ProductDto;

import java.util.List;

public interface ProductRepository {

    List<ProductDto> getProductsByCategoryId(String groupUrl);

    List<ProductDto> getRelationsForAllProductsInCategory (String groupUrl);


}
