package com.bodax.home.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductPropertiesDto {
    @JsonProperty("property_id")
    private Integer propertyId;
    @JsonProperty("characteristic")
    private String propertyName;
    private String value;

}
