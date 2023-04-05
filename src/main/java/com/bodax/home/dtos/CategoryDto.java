package com.bodax.home.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {
    @JsonProperty("category_id")
    private Long id;
    private String name;
    private String url;

    @JsonProperty("parent_id")
    private Long parentId;
    private String filename;

}
