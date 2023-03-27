package com.bodax.home.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryPageInfoDto {

    List<ProductDto> relatedProducts;
    List<PropertyDto> values;

}
