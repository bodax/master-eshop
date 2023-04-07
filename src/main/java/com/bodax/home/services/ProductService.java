package com.bodax.home.services;

import com.bodax.home.dtos.ProductDto;
import com.bodax.home.dtos.ProductMetaInfo;
import com.bodax.home.dtos.ProductPropertiesDto;

import java.util.List;
import java.util.Set;

public interface ProductService {

    List<ProductDto> getProductByCategory(String groupUrl);

    List<ProductDto> getRelationOfAllCategoryProducts(String groupUrl);

    ProductDto getProductById(String productId);

    Set<String> getPhotosNameByProductUrl(String url);

    List<ProductPropertiesDto> getProductProperties(String productUrl);

    List<ProductDto> getRelatedProducts(String productUrl);

    String getProductDescription(String productUrl);

    ProductMetaInfo getProductMetaInfo(String productUrl);
}
