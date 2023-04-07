package com.bodax.home.dtos;

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

    @JsonProperty("related_products")
    private List<ProductDto> relatedProducts;

    private String description;

    @JsonProperty("meta")
    private ProductMetaInfo productMetaInfo;

}
