package com.bodax.home.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class ProductMetaInfo extends MetaInfo {

    @JsonProperty("product_id")
    @Override
    public Integer getId() {
        return super.getId();
    }


}
