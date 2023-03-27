package com.bodax.home.services;

import com.bodax.home.domain.repository.ProductRepository;
import com.bodax.home.dtos.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
