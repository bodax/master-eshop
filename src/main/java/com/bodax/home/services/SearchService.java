package com.bodax.home.services;

import com.bodax.home.dtos.ProductDto;

import java.util.List;

public interface SearchService {

    List<ProductDto> getProductsByUserSearch(String searchText, Integer page);

}
