package com.bodax.home.services;

import com.bodax.home.domain.repository.ProductRepository;
import com.bodax.home.dtos.ProductDto;
import com.bodax.home.dtos.ProductMetaInfo;
import com.bodax.home.dtos.ProductPropertiesDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getProductByCategory(String groupUrl) {
        return productRepository.getProductsByCategoryId(groupUrl);
    }

    @Override
    public List<ProductDto> getRelationOfAllCategoryProducts(String groupUrl) {
        return productRepository.getRelationsForAllProductsInCategory(groupUrl);
    }

    @Override
    public ProductDto getProductById(String productId) {
        return productRepository.getProductByUrl(productId);
    }

    @Override
    public Set<String> getPhotosNameByProductUrl(String url) {
        return productRepository.getProductPhotosByCategoryUrl(url);
    }

    @Override
    public List<ProductPropertiesDto> getProductProperties(String productUrl) {
        return productRepository.getProductPropertiesByUrl(productUrl);
    }

    @Override
    public List<ProductDto> getRelatedProducts(String productUrl) {
        return productRepository.getRelatedProducts(productUrl);
    }

    @Override
    public String getProductDescription(String productUrl) {
        return productRepository.getProductDescriptionByUrl(productUrl);
    }

    @Override
    public ProductMetaInfo getProductMetaInfo(String productUrl) {
        return productRepository.getProductMetaInfo(productUrl);
    }

    @Override
    public List<ProductDto> getDiscountProducts() {
        return productRepository.getDiscountProducts();
    }

    @Override
    public List<ProductDto> getNewProducts() {
        return productRepository.getNewProducts();
    }

    @Override
    public List<ProductDto> getProductsByIds(Set<Integer> watchedProductIds) {
        return productRepository.getProductsByIds(watchedProductIds);
    }

    @Override
    public List<?> getProductNews() {
        return null;
    }
}
