package com.bodax.home.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CategoryMetaInfoDto {

    @JsonProperty("category_id")
    private Integer categoryId;

    @JsonProperty("name")
    private String categoryName;

    private String description;

    @JsonProperty("meta_description")
    private String metaDescription;

    @JsonProperty("meta_keywords")
    private String metaKeywords;

    @JsonProperty("meta_title")
    private String metaTitle;


}
