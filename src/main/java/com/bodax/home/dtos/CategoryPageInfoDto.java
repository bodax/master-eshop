package com.bodax.home.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class CategoryPageInfoDto implements Serializable {

    List<ProductDto> relatedProducts;
    List<PropertyValuesDto> values;
    List<CategoryPropertyDto> characteristics;

    List<ManufacturerDto> manufacturers;

    @JsonProperty("meta")
    List<CategoryMetaInfoDto> categoryMetaInfo;
}
