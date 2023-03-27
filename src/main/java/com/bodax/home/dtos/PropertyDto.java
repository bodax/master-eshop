package com.bodax.home.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PropertyDto {
    @JsonProperty("property_id")
    private Integer propertyId;
    private String name;
    @JsonProperty("property_value_id")
    private Integer propertyValueId;

}
