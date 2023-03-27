package com.bodax.home.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDto {

    @JsonProperty("product_id")
    private Integer productId;

    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("category_id")
    private String categoryId;
    @JsonProperty("category_name")
    private String categoryName;
    private String url;
    private String fileName;
    @JsonProperty("base_price")
    private Double price;
    private String iso;
    @JsonProperty("discount_percent")
    private Double discountPercent;
}
