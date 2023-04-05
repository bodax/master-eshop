package com.bodax.home.services;

import com.bodax.home.dtos.ProductDto;
import com.bodax.home.dtos.ProductPropertiesDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ProductInfoPageDto {

    @JsonProperty("product_information")
    private ProductDto product;

    private Set<String> photos;

    @JsonProperty("characteristics")
    private List<ProductPropertiesDto> productProperties;

}
