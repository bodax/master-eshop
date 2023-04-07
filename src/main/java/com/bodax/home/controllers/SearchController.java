package com.bodax.home.controllers;

import com.bodax.home.dtos.ProductDto;
import com.bodax.home.services.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/api/page/search")
    private Map<String, List<ProductDto>> getProductByUserSearch(@RequestParam String src, @RequestParam Integer page) {
        var products = searchService.getProductsByUserSearch(src, page);

        return Map.of("data", products);
    }

}
