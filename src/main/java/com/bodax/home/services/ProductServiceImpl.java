package com.bodax.home.services;

import com.bodax.home.domain.repository.ProductRepository;
import com.bodax.home.dtos.ProductDto;
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
}
