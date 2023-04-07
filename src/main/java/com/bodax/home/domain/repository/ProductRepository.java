package com.bodax.home.domain.repository;

import com.bodax.home.dtos.ProductDto;
import com.bodax.home.dtos.ProductMetaInfo;
import com.bodax.home.dtos.ProductPropertiesDto;

import java.util.List;
import java.util.Set;

public interface ProductRepository {

    List<ProductDto> getProductsByCategoryId(String groupUrl);

    List<ProductDto> getRelationsForAllProductsInCategory (String groupUrl);

    ProductDto getProductByUrl(String productId);

    Set<String> getProductPhotosByCategoryUrl(String url);

    List<ProductPropertiesDto> getProductPropertiesByUrl(String productUrl);

    List<ProductDto> getRelatedProducts(String productUrl);

    String getProductDescriptionByUrl(String productUrl);

    ProductMetaInfo getProductMetaInfo(String productUrl);
}
