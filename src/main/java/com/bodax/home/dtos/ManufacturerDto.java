package com.bodax.home.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ManufacturerDto {

    @JsonProperty("manufacturer_id")
    private Integer manufacturerId;

    private String name;

}
