package com.bodax.home.controllers;

import com.bodax.home.dtos.ProductDto;
import com.bodax.home.services.ProductInfoPageDto;
import com.bodax.home.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //TODO: refactor api url
    @GetMapping("/api/page/category")
    public Map<String, List<ProductDto>> getProductsByCategoryId(@RequestParam String groupUrl, @RequestParam Integer page, @RequestParam String lan) {
        return Map.of("data", productService.getProductByCategory(groupUrl));
    }

    @GetMapping("/api/page/product/{productUrl}")
    public Map<String, ProductInfoPageDto> getProductById(@PathVariable String productUrl, @RequestParam String lan) {
        ProductInfoPageDto productInfoPage = new ProductInfoPageDto();
        productInfoPage.setProduct(productService.getProductById(productUrl));
        productInfoPage.setPhotos(productService.getPhotosNameByProductUrl(productUrl));
        productInfoPage.setProductProperties(productService.getProductProperties(productUrl));
        return Map.of("productInfo", productInfoPage);
    }

}
