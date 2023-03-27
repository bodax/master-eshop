package com.bodax.home.dtos;

import com.bodax.home.domain.entity.Category;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class EntryPageInfoDto implements Serializable {
    private List<Category> categories;
}
