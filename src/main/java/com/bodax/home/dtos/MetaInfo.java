package com.bodax.home.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class MetaInfo {
    private Integer id;
    @JsonProperty("name")
    private String name;
    private String description;

    @JsonProperty("meta_description")
    private String metaDescription;

    @JsonProperty("meta_keywords")
    private String metaKeywords;

    @JsonProperty("meta_title")
    private String metaTitle;

}
