package com.bodax.home.services;

import com.bodax.home.domain.repository.ProductRepository;
import com.bodax.home.dtos.ProductDto;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    private final ProductRepository productRepository;

    public SearchServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getProductsByUserSearch(String searchText, Integer page) {
        if (searchText == null || searchText.isEmpty()) {
            return Collections.emptyList();
        }
        return productRepository.getProductsByUserSearch(convertForDBFormat(searchText), page);
    }

    private String convertForDBFormat(String searchText) {
        return '%' + searchText + '%';
    }
}
